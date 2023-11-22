package br.net.galdino.restfulwebservices.bean;

import com.fasterxml.jackson.annotation.JsonFilter;

//@JsonIgnoreProperties({"field1", "field2"})
@JsonFilter("SomeBeanFilter")
public class SomeBean {
	
	private String field1;
	
	//@JsonIgnore
	private String field2;
	private String field3;
	
	public SomeBean() {}

	public SomeBean(String field1, String field2, String field3) {
		super();
		this.field1 = field1;
		this.field2 = field2;
		this.field3 = field3;
	}

	public String getfield1() {
		return field1;
	}

	public String getfield2() {
		return field2;
	}

	public String getfield3() {
		return field3;
	}

	@Override
	public String toString() {
		return "SomeBean [field1=" + field1 + ", field2=" + field2 + ", field3=" + field3 + "]";
	}
	
}
