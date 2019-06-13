/**
 * 
 */
package com.nisum.zipcodes;

/**
 * @author borages
 *
 */
public class ZipcodeRangeValue {

	private Integer lowerBound;
	private Integer upperBound;
	
	public ZipcodeRangeValue(Integer lowerBound, Integer upperBound) {
		this.lowerBound = lowerBound;
		this.upperBound = upperBound;
	}
	
	public Integer getLowerBound() {
		return lowerBound;
	}
	public void setLowerBound(Integer lowerBound) {
		this.lowerBound = lowerBound;
	}
	public Integer getUpperBound() {
		return upperBound;
	}
	public void setUpperBound(Integer upperBound) {
		this.upperBound = upperBound;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((lowerBound == null) ? 0 : lowerBound.hashCode());
		result = prime * result + ((upperBound == null) ? 0 : upperBound.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ZipcodeRangeValue other = (ZipcodeRangeValue) obj;
		if (lowerBound == null) {
			if (other.lowerBound != null)
				return false;
		} else if (!lowerBound.equals(other.lowerBound))
			return false;
		if (upperBound == null) {
			if (other.upperBound != null)
				return false;
		} else if (!upperBound.equals(other.upperBound))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "[" + lowerBound + "," + upperBound + "]";
	}
	
	
}
