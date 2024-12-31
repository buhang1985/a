package iih.bd.pp.hpsrvorca.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface HpStatusEnum {

    @DmEnumDesc(name="未匹配",description="NOT_MATCHED")
    public static final String NOT_MATCHED="0"; //未匹配
    @DmEnumDesc(name="已匹配",description="MATCHED")
    public static final String MATCHED="1"; //已匹配
    @DmEnumDesc(name="已对照",description="CONTRAST")
    public static final String CONTRAST="2"; //已对照
    @DmEnumDesc(name="已上传",description="UPLOAD")
    public static final String UPLOAD="3"; //已上传
    @DmEnumDesc(name="已审核",description="REVIEW")
    public static final String REVIEW="4"; //已审核
    @DmEnumDesc(name="驳回",description="REJECT")
    public static final String REJECT="5"; //驳回
    @DmEnumDesc(name="自费",description="OWNEXPENS")
    public static final String OWNEXPENS="6"; //自费
}	
