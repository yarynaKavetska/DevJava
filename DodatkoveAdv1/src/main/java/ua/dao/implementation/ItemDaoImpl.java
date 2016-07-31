package ua.dao.implementation;

import javax.persistence.EntityManager;

import ua.untity.shop.Item;

public class ItemDaoImpl extends GenericDaoImpl<Item, Integer>{

	public ItemDaoImpl(EntityManager em) {
		super(Item.class, em);
	}

}
