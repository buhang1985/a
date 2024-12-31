package iih.ci.ord.s.bp.ordprn;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import iih.ci.ord.ordprn.d.OrdPrintDO;
import iih.mp.nr.i.IMpNrMaintanceService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

public class OrdPrintUtils {
	/**
	 * 获取动态条件语句(不要改这个逻辑，需要改变医嘱单显示医嘱范围的话应配置自定义档案)
	 * @param fg_long
	 * @param fg_herb
	 * @param tablename
	 * @return
	 */
	public static String getDynamicWhereSql(FBoolean fg_long, FBoolean fg_herb, String tablename) {
		StringBuffer sqlWhrDynamic = new StringBuffer();
		if (FBoolean.TRUE.equals(fg_long)) {
			if (FBoolean.TRUE.equals(fg_herb)) {
				sqlWhrDynamic.append(MessageFormat.format(" and ({0}.fg_long=''Y'' or {1}.sd_srvtp like ''0103%'') ", tablename, tablename));
			} else if (FBoolean.FALSE.equals(fg_herb)) {
				sqlWhrDynamic.append(MessageFormat.format(" and {0}.fg_long=''Y'' ", tablename));
			}
		} else if (FBoolean.FALSE.equals(fg_long)) {
			if (FBoolean.TRUE.equals(fg_herb)) {
				sqlWhrDynamic.append(MessageFormat.format(" and {0}.fg_long=''N'' ", tablename));
			} else if (FBoolean.FALSE.equals(fg_herb)) {
				sqlWhrDynamic.append(MessageFormat.format(" and {0}.fg_long=''N'' and {1}.sd_srvtp not like ''0103%'' ", tablename, tablename));
			}
		} else if (FBoolean.TRUE.equals(fg_herb)) {
			sqlWhrDynamic.append(MessageFormat.format(" and {0}.sd_srvtp like ''0103%'' ", tablename));
		}
		
		return sqlWhrDynamic.toString();
	}
	
	/**
	 * 医嘱单打印时 和 清空时  调用执行域接口：
	 * 业务流程： 执行域  护士执行过一条临时医嘱后(执行表mp_or_pr ) 会在mp_or_nur表添加一条数据 功能节点为 医嘱执行护士维护  可批量修改执行人和执行时间
	 * 临床域业务：医嘱打印之后(临时医嘱) 调用执行域接口，将mp_or_nur表的对应数据的 是否可修改字段(fg_readonly)变为false  清空后变为true
	 * false时  不可批量修改  true反之
	 * @throws BizException 
	 */
	public static void execMPService(List<OrdPrintDO> prnDOList, FBoolean fBoolean) throws BizException {
		
		if (prnDOList.size() < 1) return;
		List<String> idOrList = new ArrayList<>();
		for (OrdPrintDO prnDO : prnDOList) {
			idOrList.add(prnDO.getId_or());
		}
		if (idOrList.size() > 0) {
			IMpNrMaintanceService mpService = ServiceFinder.find(IMpNrMaintanceService.class);
			mpService.updateOrPrntStatus(idOrList.toArray(new String[idOrList.size()]), fBoolean);
		}
	}
}
