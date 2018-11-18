package org.p.project.member.dto;

public class MemberDTO {
	private String sessionId;
	private String sessionPw;
	private boolean useCookie;
	
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	public String getSessionPw() {
		return sessionPw;
	}
	public void setSessionPw(String sessionPw) {
		this.sessionPw = sessionPw;
	}
	public boolean isUseCookie() {
		return useCookie;
	}
	public void setUseCookie(boolean useCookie) {
		this.useCookie = useCookie;
	}
	@Override
	public String toString() {
		return "MemberDTO [sessionId=" + sessionId + ", sessionPw=" + sessionPw + ", useCookie=" + useCookie + "]";
	}
}
	