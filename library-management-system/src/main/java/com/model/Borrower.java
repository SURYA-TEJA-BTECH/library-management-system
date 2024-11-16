package com.model;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Borrower {

	private String membershipId;

	@NonNull
	private String name;

	@NonNull
	private String phoneNumber;

	private Boolean isActive;

	private Map<String, LocalDate> borrowedBooks = new HashMap<String, LocalDate>();
}
