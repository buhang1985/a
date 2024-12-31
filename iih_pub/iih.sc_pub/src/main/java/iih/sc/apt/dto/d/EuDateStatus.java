package iih.sc.apt.dto.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface EuDateStatus {

    @DmEnumDesc(name="等待时间预警",description="等待时间预警")
    public static final String WAIT="0"; //等待时间预警
    @DmEnumDesc(name="占用时间预警",description="占用时间预警")
    public static final String OCCP="1"; //占用时间预警
    @DmEnumDesc(name="申请时间",description="申请时间")
    public static final String INSERT="2"; //申请时间
}	
