package iih.ci.rcm;

public class MiddleRelationDTO {
	private String mainCardId;

	private String viceCardId;

	public String getMainCardId() {
		return mainCardId;
	}

	public void setMainCardId(String mainCardId) {
		this.mainCardId = mainCardId;
	}

	public String getViceCardId() {
		return viceCardId;
	}

	public void setViceCardId(String viceCardId) {
		this.viceCardId = viceCardId;
	}

	public String getViceType() {
		return ViceType;
	}

	public void setViceType(String viceType) {
		ViceType = viceType;
	}

	private String ViceType;

}
