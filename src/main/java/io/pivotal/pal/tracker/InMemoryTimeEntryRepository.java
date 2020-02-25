package io.pivotal.pal.tracker;

import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryTimeEntryRepository implements TimeEntryRepository{

    private Map<Long, TimeEntry> timeEntryMap = new HashMap<>();
    private long nextId = 0;

    public TimeEntry create(TimeEntry timeEntry) {
        if(timeEntry.getId()==0) {
            nextId++;
            timeEntry.setId(nextId);
        }
        timeEntryMap.put(timeEntry.getId(), timeEntry);
        return timeEntry;
    }

    public TimeEntry find(long id) {
        return timeEntryMap.get(id);
    }

    public List<TimeEntry> list() {
        return new ArrayList<>(timeEntryMap.values());
    }

    public TimeEntry update(long id, TimeEntry timeEntry) {
        if(timeEntryMap.containsKey(id)) {
            timeEntry.setId(id);
            timeEntryMap.put(id, timeEntry);
            return timeEntry;
        }
        return null;
    }

    public void delete(long id) {
        timeEntryMap.remove(id);

    }
}
