package ua.service.implementation.specification;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;

import ua.entity.AmountAndIngredient;
import ua.form.AmountFilter;

public class AmountFilterAdapter implements Specification<AmountAndIngredient> {

	private final AmountFilter amountFilter;

	private final List<Specification<AmountAndIngredient>> list = new ArrayList<>();

	public AmountFilterAdapter(AmountFilter amountFilter) {
		this.amountFilter = amountFilter;
	}

	private void findByMsId() {
		if (amountFilter.getMsId() != null) {
			list.add((root, cq, cb) -> root.get("measuringSystem").in(
					amountFilter.getMsId()));
		}
	}

	private void findByIngredientId() {
		if (amountFilter.getIngredientId() != null) {
			list.add((root, cq, cb) -> root.get("ingredient").in(
					amountFilter.getIngredientId()));
		}
	}

	private void findByMaxMin() {
		if (amountFilter.getMax() != 0 && amountFilter.getMin() != 0) {
			list.add((root, cq, cb) -> {
				Expression<Integer> exp = root.get("amount");
				return cb.between(exp, amountFilter.getMin(),
						amountFilter.getMax());
			});
		} else if (amountFilter.getMax() != 0) {
			list.add((root, cq, cb) -> {
				Expression<Integer> exp = root.get("amount");
				return cb.lessThan(exp, amountFilter.getMax());
			});
		} else if (amountFilter.getMin() != 0) {
			list.add((root, cq, cb) -> {
				Expression<Integer> exp = root.get("amount");
				return cb.greaterThan(exp, amountFilter.getMin());
			});
		}
	}

	@Override
	public Predicate toPredicate(Root<AmountAndIngredient> root,
			CriteriaQuery<?> query, CriteriaBuilder cb) {
		if (query.getResultType() != Long.class
				&& query.getResultType() != long.class) {
			root.fetch("ingredient");
			root.fetch("measuringSystem");
			query.distinct(true);
		}
		if (amountFilter != null) {
			findByIngredientId();
			findByMaxMin();
			findByMsId();
		}
		if (list.size() == 0)return null;
		Specifications<AmountAndIngredient> spec = Specifications.where(list.get(0));
		for (int i = 1; i < list.size(); i++) {
			spec = spec.and(list.get(i));
		}
		return spec.toPredicate(root, query, cb);
	}

}
