package ua.service.implementation.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import ua.entity.MeasuringSystem;
import ua.form.filter.MeasuringSystemFilterForm;

public class MeasuringSystemFilterAdapter implements Specification<MeasuringSystem>{

	private String search = "";

	public MeasuringSystemFilterAdapter(MeasuringSystemFilterForm form) {
		search = form.getSearch();
	}

	@Override
	public Predicate toPredicate(Root<MeasuringSystem> root, CriteriaQuery<?> query,
			CriteriaBuilder cb) {
		if (query.getResultType() != Long.class
				&& query.getResultType() != long.class) {
			// root.fetch("ingredient");
			// root.fetch("measuringSystem");
			// query.distinct(true);
		}
		Expression<String> exp = root.get("name");
		return cb.like(cb.upper(exp), search.toUpperCase() + "%");
	}
}
