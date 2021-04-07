package com.cogpunk.math.probability;

import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;

/**
 * Tuple for defining the probability of a given event
 * 
 * @param <E>  The class defining the event
 * @param <P> The class defining the probability
 */
public class EventProbability<E, P> {
	
	private final E event;
	
	private final P probability;

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
	public String toString() {
		return "DiceRollResult [event=" + event + ", probability=" + probability + "]";
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(final Object other) {
		if (!(other instanceof EventProbability)) {
			return false;
		}
		EventProbability<?, ?> castOther = (EventProbability<?, ?>) other;
		return new EqualsBuilder().append(event, castOther.event).append(probability, castOther.probability).isEquals();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(event).append(probability).toHashCode();
	}
	
	

}
