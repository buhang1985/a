package iih.bl.pub.dto.d;

public class BlOepSrvEventInfoDTO {
	
	public Integer oper_type;//操作类型（1：收费；-1：退费）BookRtnDirectEnum
	public String[] idSrvArr;//服务ID数组
	
	public Integer getOper_type() {
		return oper_type;
	}
	public void setOper_type(Integer oper_type) {
		this.oper_type = oper_type;
	}
	public String[] getIdSrvArr() {
		return idSrvArr;
	}
	public void setIdSrvArr(String[] idSrvArr) {
		this.idSrvArr = idSrvArr;
	}
	
}
