package org.ctrip.ops.sysdev.filters;

import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;

public class Remove extends BaseFilter {
	public Remove(Map config, ArrayBlockingQueue inputQueue) {
		super(config, inputQueue);
	}

	private ArrayList<String> fields;

	protected void prepare() {
		this.fields = (ArrayList<String>) config.get("fields");
	};

	@Override
	protected void filter(final Map event) {
		for (String t : this.fields) {
			event.remove(t);
		}
	}
}