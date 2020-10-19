package com.shaan.shoppingcart.enums;

public enum CustomerTypeEnum {

////////////////////////////////////////////////////////////////////////////////
//
// Definitions of the enumeration
//
////////////////////////////////////////////////////////////////////////////////

	GENERAL("GENERAL", "GENERAL"),
	PREMIUM("PREMIUM", "PREMIUM");

	/**
	 * Key used to get the text associated with the enumeration.
	 */
	private final String code;

	/**
	 * Value associated with the enumeration.
	 */
	private final String name;

	/**
	 * Construct with values.
	 *
	 * @param code Code or type of the enumeration.
	 * @param name Key used to get the text associated with the enumeration.
	 */
	CustomerTypeEnum(final String code, final String name) {
		this.code = code;
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}
	
	public static CustomerTypeEnum decode(final String value) {
		CustomerTypeEnum decodedEnumType = null;

        if (value != null && value != "") {
        	CustomerTypeEnum[] enumTypes = values();
            for (final CustomerTypeEnum enumType : enumTypes) {
                if (value.equalsIgnoreCase(enumType.getCode())) {
                    decodedEnumType = enumType;
                    break;
                }
            }
        }
        return decodedEnumType;
    }

}
