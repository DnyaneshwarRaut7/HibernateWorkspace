package com.amazone.addcart.Service;

public abstract interface ServiceI {

	public abstract void addCartAndWithItemData();

	void showAllCatData();

	void getSingleCartData();

	void updateCartData();

	void UpdataPerticularItemsUsingCratId();

	void deletePertiularItemsDataFromCartusingCartId();

	void deleteCartData();

}
