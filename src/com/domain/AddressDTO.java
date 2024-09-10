package com.domain;

public class AddressDTO {
//	테이블명		tml_address
//	컬럼		address_id(pk)	address_postal_code	
//			address_line1	address link2
	
	// 필드
	private int addressId;
	private int addressPostalCode;
	private String addressLine1;
	private String addressLine2;
	
	// 생성자
	public AddressDTO() {
		super();
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public int getAddressPostalCode() {
		return addressPostalCode;
	}

	public void setAddressPostalCode(int addressPostalCode) {
		this.addressPostalCode = addressPostalCode;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	@Override
	public String toString() {
		return "AddressDTO [addressId=" + addressId + ", addressPostalCode=" + addressPostalCode + ", addressLine1="
				+ addressLine1 + ", addressLine2=" + addressLine2 + "]";
	}
	
	
	
}
