package ua.service.implementation.specification;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;

import ua.entity.AmountAndIngredient;
import ua.form.filter.IngredientAmountFilterForm;



public class IngredientAmountFilterAdapter implements Specification<AmountAndIngredient>{

	private final IngredientAmountFilterForm form;
	
	private final List<Specification<AmountAndIngredient>> filters = new ArrayList<>();	

	public IngredientAmountFilterAdapter(IngredientAmountFilterForm form) {
		if (form != null) {
			this.form = form;
		} else {
			this.form = new IngredientAmountFilterForm();
		}
	}
	
	private void findByAmount(){
		if(form.getMinInt()!=0&&form.getMaxInt()!=0){
//			filters.add((root, query, cb)->cb.between(root.get("amount"), form.getMinInt(), form.getMaxInt()));
			filters.add((root, query, cb)->{
				Expression<Integer> exp = root.get("amount");
				return cb.between(exp, form.getMinInt(), form.getMaxInt());
			});
		}else if(form.getMinInt()!=0){
			filters.add((root, query, cb)->{
				Expression<Integer> exp = root.get("amount");
				return cb.ge(exp, form.getMinInt());
			});
		}else if(form.getMaxInt()!=0){
			filters.add((root, query, cb)->{
				Expression<Integer> exp = root.get("amount");
				return cb.le(exp, form.getMaxInt());
			});
		}
	}
	
	private void findByIngredient(){
		if(!form.getIngredientIds().isEmpty()){
			filters.add((root, query, cb)->root.get("ingredient").in(form.getIngredientIds()));
		}
	}
	
	private void findByMs(){
		if(!form.getMsIds().isEmpty()){
			filters.add((root, query, cb)->root.get("measuringSystem").in(form.getMsIds()));
		}
	}

	@Override
	public Predicate toPredicate(Root<AmountAndIngredient> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		if (query.getResultType() != Long.class && query.getResultType() != long.class) {
			root.fetch("ingredient", JoinType.LEFT);
			root.fetch("measuringSystem", JoinType.LEFT);
		}
		findByAmount();
		findByIngredient();
		findByMs();
		if(!filters.isEmpty()){
			Specifications<AmountAndIngredient> spec = Specifications.where(filters.get(0));
			for(Specification<AmountAndIngredient> s : filters.subList(1, filters.size())){
				spec = spec.and(s);
			}
			return spec.toPredicate(root, query, cb);
		}
		return null;
	}
}
