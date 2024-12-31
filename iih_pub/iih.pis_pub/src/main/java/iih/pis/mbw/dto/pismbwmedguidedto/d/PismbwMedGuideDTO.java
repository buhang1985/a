package iih.pis.mbw.dto.pismbwmedguidedto.d;

import java.util.List;
import xap.mw.sf.core.annotation.RPCField;
import xap.mw.sf.core.annotation.RPCStruct;
@RPCStruct
public class PismbwMedGuideDTO {

	// 发布人
	@RPCField(id = 1)
	private String id_psndoc;
	// 最后修改时间
	@RPCField(id = 10)
	private String modifiedtime;
	// 发布单位名称
	@RPCField(id = 11)
	private String name_dep;
	// 是否启用
	@RPCField(id = 12)
	private boolean fg_active;
	// 就医指南id
	@RPCField(id = 13)
	private String id_medguide;
	// 标题
	@RPCField(id = 14)
	private String title;
	// 副标题
	@RPCField(id = 15)
	private String subtitle;
	// 正文
	@RPCField(id = 16)
	private String content;
	// 发布时间
	@RPCField(id = 17)
	private String dt_publish;
	// 通知类型
	@RPCField(id = 18)
	private boolean fg_notify;
	// 阅读量
	@RPCField(id = 19)
	private int pviews;
	// 发布人名称
	@RPCField(id = 2)
	private String name_psndoc;
	// 发布单位
	@RPCField(id = 20)
	private String id_dep;
	// 指南类型
	@RPCField(id = 3)
	private String id_guidetp;
	// 指南类型编码
	@RPCField(id = 4)
	private String code_guidetp;
	// 置顶
	@RPCField(id = 5)
	private boolean fg_istop;
	// 序号
	@RPCField(id = 6)
	private int sortno;
	// 创建人
	@RPCField(id = 7)
	private String createdby;
	// 创建时间
	@RPCField(id = 8)
	private String createdtime;
	// 最后修改人
	@RPCField(id = 9)
	private String modifiedby;

	public String getId_psndoc() {
		return id_psndoc;
	}

	public void setId_psndoc(String id_psndoc) {
		this.id_psndoc = id_psndoc;
	}

	public String getModifiedtime() {
		return modifiedtime;
	}

	public void setModifiedtime(String modifiedtime) {
		this.modifiedtime = modifiedtime;
	}

	public String getName_dep() {
		return name_dep;
	}

	public void setName_dep(String name_dep) {
		this.name_dep = name_dep;
	}

	public boolean getFg_active() {
		return fg_active;
	}

	public void setFg_active(boolean fg_active) {
		this.fg_active = fg_active;
	}

	public String getId_medguide() {
		return id_medguide;
	}

	public void setId_medguide(String id_medguide) {
		this.id_medguide = id_medguide;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubtitle() {
		return subtitle;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDt_publish() {
		return dt_publish;
	}

	public void setDt_publish(String dt_publish) {
		this.dt_publish = dt_publish;
	}

	public boolean getFg_notify() {
		return fg_notify;
	}

	public void setFg_notify(boolean fg_notify) {
		this.fg_notify = fg_notify;
	}

	public int getPviews() {
		return pviews;
	}

	public void setPviews(int pviews) {
		this.pviews = pviews;
	}

	public String getName_psndoc() {
		return name_psndoc;
	}

	public void setName_psndoc(String name_psndoc) {
		this.name_psndoc = name_psndoc;
	}

	public String getId_dep() {
		return id_dep;
	}

	public void setId_dep(String id_dep) {
		this.id_dep = id_dep;
	}

	public String getId_guidetp() {
		return id_guidetp;
	}

	public void setId_guidetp(String id_guidetp) {
		this.id_guidetp = id_guidetp;
	}

	public String getCode_guidetp() {
		return code_guidetp;
	}

	public void setCode_guidetp(String code_guidetp) {
		this.code_guidetp = code_guidetp;
	}

	public boolean getFg_istop() {
		return fg_istop;
	}

	public void setFg_istop(boolean fg_istop) {
		this.fg_istop = fg_istop;
	}

	public int getSortno() {
		return sortno;
	}

	public void setSortno(int sortno) {
		this.sortno = sortno;
	}

	public String getCreatedby() {
		return createdby;
	}

	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}

	public String getCreatedtime() {
		return createdtime;
	}

	public void setCreatedtime(String createdtime) {
		this.createdtime = createdtime;
	}

	public String getModifiedby() {
		return modifiedby;
	}

	public void setModifiedby(String modifiedby) {
		this.modifiedby = modifiedby;
	}

}
