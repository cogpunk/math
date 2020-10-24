package com.cogpunk.math.probability;

/**
 * Tuple for defining the probability of a given event
 * 
 * @param <E>  The class defining the event
 * @param <P> The class defining the probability
 */
public class EventProbability<E, P> {
	
	private E event;
	
	private P probability;

	public EventProbability(E event, P probability) {
		super();
		this.event = event;
		this.probability = probability;
	}

	public E getEvent() {
		return event;
	}

	public P getProbability() {
		return probability;
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((event == null) ? 0 : event.hashCode());
		result = prime * result + ((probability == null) ? 0 : probability.hashCode());
		return result;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EventProbability other = (EventProbability) obj;
		if (event == null) {
			if (other.event != null)
				return false;
		} else if (!event.equals(other.event))
			return false;
		if (probability == null) {
			if (other.probability != null)
				return false;
		} else if (!probability.equals(other.probability))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DiceRollResult [event=" + event + ", probability=" + probability + "]";
	}
	
	

}
