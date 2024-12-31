package iih.bl.cg.service.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

/**
 * 医生站开立记账接口 所需要的记账类型
 * @author tcy
 * @since 2017-5-24
 */
public interface CgTypeEnum {
	@DmEnumDesc(name="预交金记账",description="预交金记账")
    public static final String CG_PREPAY="1"; //预交金记账
    @DmEnumDesc(name="高端商保记账",description="高端商保记账")
    public static final String CG_HPCG="2"; //高端商保记账
    @DmEnumDesc(name="科研項目记账",description="科研項目记账")
    public static final String CG_RESEARCH="3"; //高端商保记账

}
