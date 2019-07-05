package com.securegion.eddieui.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CheckResult {
	Status status;
	Code code;
	String description;
	String resultdata;

	public void setStatusBool(boolean ok) {
		this.status = ok ? Status.UP : Status.DOWN;
	}

    public enum Code {
        OK, ERROR, MISSING_REQUIRED_CONFIG, REMOVED_MONITOR, PAUSED
    }
}
