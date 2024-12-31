package iih.mbh.bl.bltpl.d;

import java.util.List;
import xap.mw.sf.core.annotation.RPCField;
import xap.mw.sf.core.annotation.RPCStruct;
@RPCStruct
public class BlTplItmDTO {

	// 自定义模板明细主键
	@RPCField(id = 1)
	private String id_bltplitm;
	// 自定义费用模板
	@RPCField(id = 2)
	private String id_bltpl;
	// 服务项目
	@RPCField(id = 3)
	private String id_srv;
	// 补录服务编码
	@RPCField(id = 4)
	private String code_srv;
	// 补录服务名称
	@RPCField(id = 5)
	private String name_srv;
	// 标准单价
	@RPCField(id = 6)
	private String price_std;

	public String getId_bltplitm() {
		return id_bltplitm;
	}

	public void setId_bltplitm(String id_bltplitm) {
		this.id_bltplitm = id_bltplitm;
	}

	public String getId_bltpl() {
		return id_bltpl;
	}

	public void setId_bltpl(String id_bltpl) {
		this.id_bltpl = id_bltpl;
	}

	public String getId_srv() {
		return id_srv;
	}

	public void setId_srv(String id_srv) {
		this.id_srv = id_srv;
	}

	public String getCode_srv() {
		return code_srv;
	}

	public void setCode_srv(String code_srv) {
		this.code_srv = code_srv;
	}

	public String getName_srv() {
		return name_srv;
	}

	public void setName_srv(String name_srv) {
		this.name_srv = name_srv;
	}

	public String getPrice_std() {
		return price_std;
	}

	public void setPrice_std(String price_std) {
		this.price_std = price_std;
	}

}
