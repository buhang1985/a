package iih.sfda.aer.sfdaaerevfdb.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface EuRecurReportEnum {

    @DmEnumDesc(name="已上报",description="已上报")
	public static final Integer HASBEENREPORTED=1; //已上报
    @DmEnumDesc(name="未上报",description="未上报")
	public static final Integer DIDNOTREPORT=2; //未上报
}	
