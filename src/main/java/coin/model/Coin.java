package coin.model;

import java.math.BigDecimal;
import java.util.Date;

public class Coin {
	private int id;
	private String country;
	private String denomination;
	private int yearOfMinting;
	private BigDecimal currentValue;//float 
	private Date acquiredDate;
	
//no Argument constructor
	 
public Coin() {
}
// parametrise constructor

public Coin(int id, String country, String denomination, int yearOfMinting, BigDecimal currentValue,
		Date acquiredDate) {
	super();
	this.id = id;
	this.country = country;
	this.denomination = denomination;
	this.yearOfMinting = yearOfMinting;
	this.currentValue = currentValue;
	this.acquiredDate = acquiredDate;
}
public Coin( String country, String denomination, int yearOfMinting, BigDecimal currentValue,
		Date acquiredDate) {
	super();
	this.country = country;
	this.denomination = denomination;
	this.yearOfMinting = yearOfMinting;
	this.currentValue = currentValue;
	this.acquiredDate = acquiredDate;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getCountry() {
	return country;
}

public void setCountry(String country) {
	this.country = country;
}

public String getDenomination() {
	return denomination;
}

public void setDenomination(String denomination) {
	this.denomination = denomination;
}

public int getYearOfMinting() {
	return yearOfMinting;
}

public void setYearOfMinting(int yearOfMinting) {
	this.yearOfMinting = yearOfMinting;
}

public BigDecimal getCurrentValue() {
	return currentValue;
}

public void setCurrentValue(BigDecimal currentValue) {
	this.currentValue = currentValue;
}

public Date getAcquiredDate() {
	return acquiredDate;
}

public void setAcquiredDate(Date acquiredDate) {
	this.acquiredDate = acquiredDate;
}

@Override
public String toString() {
	return "Coin [id=" + id + ", country=" + country + ", denomination=" + denomination + ", yearOfMinting="
			+ yearOfMinting + ", currentValue=" + currentValue + ", acquiredDate=" + acquiredDate + "]\n";
}


}
