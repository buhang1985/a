package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class PSMReplyTansDeptApplyRequest
{
    @JsonProperty(value = "patientId")
    private String patientId;
    @JsonProperty(value = "times")
    private String times;
    @JsonProperty(value = "transTimes")
    private String transTimes;
    @JsonProperty(value = "replyTime")
    private String replyTime;
    @JsonProperty(value = "replyBedNo")
    private String replyBedNo;
    @JsonProperty(value = "replyLocationId")
    private String replyLocationId;
    @JsonProperty(value = "replyDoctorCode")
    private String replyDoctorCode;
    @JsonProperty(value = "replyOperaCode")
    private String replyOperaCode;
    @JsonProperty(value = "wardCode")
    private String wardCode;
    @JsonProperty(value = "deptCode")
    private String deptCode;
    @JsonProperty(value = "fgPri")
    private String fgPri;
    @JsonProperty(value = "wgCode")
    private String wgCode;
    @JsonProperty(value = "zrCode")
    private String zrCode;
    @JsonProperty(value = "zzCode")
    private String zzCode;
    @JsonProperty(value = "zyCode")
    private String zyCode;
    @JsonProperty(value = "phyCode")
    private String phyCode;
    @JsonProperty(value = "nurCode")
    private String nurCode;
    @JsonProperty(value = "Id_wg")
    private String Id_wg;
    
    
	public String getFgPri() {
		return fgPri;
	}
	public void setFgPri(String fgPri) {
		this.fgPri = fgPri;
	}
	public String getWgCode() {
		return wgCode;
	}
	public void setWgCode(String wgCode) {
		this.wgCode = wgCode;
	}
	public String getZrCode() {
		return zrCode;
	}
	public void setZrCode(String zrCode) {
		this.zrCode = zrCode;
	}
	public String getZzCode() {
		return zzCode;
	}
	public void setZzCode(String zzCode) {
		this.zzCode = zzCode;
	}
	public String getZyCode() {
		return zyCode;
	}
	public void setZyCode(String zyCode) {
		this.zyCode = zyCode;
	}
	public String getPhyCode() {
		return phyCode;
	}
	public void setPhyCode(String phyCode) {
		this.phyCode = phyCode;
	}
	public String getNurCode() {
		return nurCode;
	}
	public void setNurCode(String nurCode) {
		this.nurCode = nurCode;
	}
	public String getWardCode() {
		return wardCode;
	}
	public void setWardCode(String wardCode) {
		this.wardCode = wardCode;
	}
	public String getDeptCode() {
		return deptCode;
	}
	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}
	public String getPatientId() {
		return patientId;
	}
	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}
	public String getTimes() {
		return times;
	}
	public void setTimes(String times) {
		this.times = times;
	}
	public String getTransTimes() {
		return transTimes;
	}
	public void setTransTimes(String transTimes) {
		this.transTimes = transTimes;
	}
	public String getReplyTime() {
		return replyTime;
	}
	public void setReplyTime(String replyTime) {
		this.replyTime = replyTime;
	}
	public String getReplyBedNo() {
		return replyBedNo;
	}
	public void setReplyBedNo(String replyBedNo) {
		this.replyBedNo = replyBedNo;
	}
	public String getReplyLocationId() {
		return replyLocationId;
	}
	public void setReplyLocationId(String replyLocationId) {
		this.replyLocationId = replyLocationId;
	}
	public String getReplyDoctorCode() {
		return replyDoctorCode;
	}
	public void setReplyDoctorCode(String replyDoctorCode) {
		this.replyDoctorCode = replyDoctorCode;
	}
	public String getReplyOperaCode() {
		return replyOperaCode;
	}
	public void setReplyOperaCode(String replyOperaCode) {
		this.replyOperaCode = replyOperaCode;
	}
	public String getId_wg() {
		return Id_wg;
	}
	public void setId_wg(String id_wg) {
		Id_wg = id_wg;
	}

}
