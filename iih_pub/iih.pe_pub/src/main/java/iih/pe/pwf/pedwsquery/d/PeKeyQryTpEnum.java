package iih.pe.pwf.pedwsquery.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface PeKeyQryTpEnum {

    @DmEnumDesc(name="体检编码",description="体检编码")
	public static final Integer PEKEYQRYPECODE=1; //体检编码
    @DmEnumDesc(name="姓名",description="姓名")
	public static final Integer PEKEYQRYNAME=2; //姓名
    @DmEnumDesc(name="电话",description="电话")
	public static final Integer PEKEYQRYMOB=3; //电话
    @DmEnumDesc(name="就诊卡",description="就诊卡")
	public static final Integer PEKEYQRYCARD=4; //就诊卡
}	
