/**
 * Represents a collision between a particle and another particle, or a particle and a wall.
 */
public class Event implements Comparable<Event> {
	double _timeOfEvent;
	double _timeEventCreated;

	/**
	 * @param timeOfEvent the time when the collision will take place
	 */
	public Event (double timeOfEvent, double timeEventCreated) {
		_timeOfEvent = timeOfEvent;
		_timeEventCreated = timeEventCreated;
	}

	@Override
	/*
	 * Compares two Events based on their event times. Since you are implementing a maximum heap,
	 * this method assumes that the event with the smaller event time should receive higher priority.
	 */
	public int compareTo (Event e) {
		if (_timeOfEvent < e._timeOfEvent) {
			return +1;
		} else if (_timeOfEvent == e._timeOfEvent) {
			return 0;
		} else {
			return -1;
		}
	}
}
