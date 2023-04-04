package com.yedam.API;

public class Member {
	@Override
	public String toString() {
		return "Member [id=" + id + "]";
	}

	public String id;
	
	public Member(String id) {
		this.id = id;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Member) {
			Member member = (Member)obj;
			if(id.equals(member.id)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public int hashCode() {
		return id.hashCode();
	}
	
	
	
	
}
