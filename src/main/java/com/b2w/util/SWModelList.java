package com.b2w.util;

import java.io.Serializable;
import java.util.List;

public class SWModelList<T> implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int count;
    public String next;
    public String previous;
    public List<T> results;

    public boolean hasMore() {
        return (next != null && !next.isEmpty());
    }

	public List<T> getResults() {
		return results;
	}
}