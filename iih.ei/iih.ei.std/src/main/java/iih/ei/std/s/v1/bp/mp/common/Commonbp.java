package iih.ei.std.s.v1.bp.mp.common;

import iih.bd.fc.orpltp.d.OrpltpStaDO;
import iih.bd.fc.orpltp.i.IOrpltpStaDORService;
import iih.ei.std.s.v1.bp.mp.common.qry.GetUdidocByCodeSql;
import iih.ei.std.s.v1.bp.mp.common.qry.GetUdidocListByCodeAndParSql;
import iih.ei.std.s.v1.bp.mp.common.qry.GetUdidocListByCodeSql;
import iih.ei.std.s.v1.bp.mp.common.qry.GetUdidocListByCodesSql;
import iih.mp.nr.i.IMpNrLogService;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.log.logging.Level;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.xbd.udi.d.UdidocDO;

public class Commonbp {

	/**
	 * 根据闭环编码获取闭环DO
	 * 
	 * @param Sd_orpltp
	 * @return
	 * @throws BizException
	 */
	public OrpltpStaDO getOrpltpByCode(String Sd_orpltp) throws BizException {
		if (!StringUtil.isEmpty(Sd_orpltp)) {
			IOrpltpStaDORService orpltpFindService = ServiceFinder.find(IOrpltpStaDORService.class);
			OrpltpStaDO[] DOS = orpltpFindService.find(" a1.code='" + Sd_orpltp + "'", "", FBoolean.FALSE);
			if (DOS != null && DOS.length > 0) {
				if (DOS.length == 1) {
					return DOS[0];
				} else {
					throw new BizException("闭环“" + Sd_orpltp + "”不唯一，请核对后重试！");
				}
			} else {
				throw new BizException("不存在闭环“" + Sd_orpltp + "”，请核对后重试！");
			}
		} else {
			throw new BizException("闭环编码不能为空，请核对后重试！");
		}
	}

	/**
	 * 根据闭环编码批量获取闭环DO
	 * 
	 * @param Sd_orpltp
	 * @return
	 * @throws BizException
	 */
	public OrpltpStaDO[] getOrpltpByCodes(String[] Sd_orpltps) throws BizException {
		if (Sd_orpltps != null && Sd_orpltps.length > 0) {
			String whereInStr = "";
			for (String sd_orpltp : Sd_orpltps) {
				whereInStr += ((whereInStr.length() == 0 ? "" : ",") + "'" + sd_orpltp + "'");
			}
			IOrpltpStaDORService orpltpFindService = ServiceFinder.find(IOrpltpStaDORService.class);
			OrpltpStaDO[] DOS = orpltpFindService.find(" a1.code in(" + whereInStr + ")", "", FBoolean.FALSE);
			if (DOS != null && DOS.length > 0) {
				return DOS;
			} else {
				throw new BizException("不存在闭环“" + Sd_orpltps + "”，请核对后重试！");
			}
		} else {
			throw new BizException("闭环编码不能为空，请核对后重试！");
		}
	}

	/**
	 * 获取全部自定义档案全部
	 * 
	 * @param UdiCode类别编码
	 * @param Code子类编码
	 * @param ContainRoot是否包含本身
	 * @return
	 * @throws BizException
	 */
	public UdidocDO[] getUdidocListByCode(String UdiCode, String Code, boolean ContainRoot) throws BizException {
		GetUdidocListByCodeSql Sql = new GetUdidocListByCodeSql(UdiCode, Code, ContainRoot);
		return (UdidocDO[]) AppFwUtil.getDORstWithDao(Sql, UdidocDO.class);
	}

	/**
	 * 获取树结构字典集合
	 * 
	 * @param udiCode
	 * @param code
	 * @param containPar
	 * @return
	 * @throws BizException
	 */
	public UdidocDO[] getUdidocListByCodeAndPar(String udiCode, String code, boolean containPar) throws BizException {
		GetUdidocListByCodeAndParSql Sql = new GetUdidocListByCodeAndParSql(udiCode, code, containPar);
		return (UdidocDO[]) AppFwUtil.getDORstWithDao(Sql, UdidocDO.class);
	}

	/**
	 * 批量获取字典
	 * 
	 * @param UdiCodes
	 * @return
	 * @throws BizException
	 */
	public UdidocDO[] getUdidocListByCodes(String[] UdiCodes) throws BizException {
		if (UdiCodes != null && UdiCodes.length > 0) {
			GetUdidocListByCodesSql Sql = new GetUdidocListByCodesSql(UdiCodes);
			return (UdidocDO[]) AppFwUtil.getDORstWithDao(Sql, UdidocDO.class);
		}
		return null;
	}

	/**
	 * 根据类别编码和想编码获取一项档案
	 * 
	 * @param UdiCode
	 * @param Code
	 * @return
	 * @throws BizException
	 */
	public UdidocDO getUdidocByCode(String UdiCode, String Code) throws BizException {
		GetUdidocByCodeSql Sql = new GetUdidocByCodeSql(UdiCode, Code);
		UdidocDO[] DOS = (UdidocDO[]) AppFwUtil.getDORstWithDao(Sql, UdidocDO.class);
		if (DOS != null) {
			if (DOS.length > 0) {
				if (DOS.length == 1) {
					return DOS[0];
				} else {
					throw new BizException("档案分类“" + UdiCode + "”中，编码为“" + Code + "”的项数量不唯一，请核对后重试！");
				}
			} else {
				throw new BizException("档案分类“" + UdiCode + "”中，不存在编码为“" + Code + "”的项，请核对后重试！");
			}
		} else {
			throw new BizException("档案分类“" + UdiCode + "”中，不存在编码为“" + Code + "”的项，请核对后重试！");
		}
	}

	/**
	 * 获取医疗服务类型编码集合
	 * 
	 * @param UdiCode
	 * @param Code
	 * @param ContainRoot
	 * @return
	 * @throws BizException
	 */
	public List<String> getListSrvtpStr(String UdiCode, String Code, boolean ContainRoot) throws BizException {
		List<String> reList = new ArrayList<String>();
		GetUdidocListByCodeSql Sql = new GetUdidocListByCodeSql(UdiCode, Code, ContainRoot);
		UdidocDO[] DOS = (UdidocDO[]) AppFwUtil.getDORstWithDao(Sql, UdidocDO.class);
		if (DOS != null && DOS.length > 0) {
			for (UdidocDO udidocDO : DOS) {
				if (!reList.contains(udidocDO.getCode())) {
					reList.add(udidocDO.getCode());
				}
			}
		}
		return reList;
	}

	/**
	 * 清空拆分后医嘱的最近执行时间
	 * 
	 * @param splitDTOS
	 * @throws BizException
	 */
	public void clearDtLastMp(BaseDTO[] splitDTOS) throws BizException {
		if (splitDTOS != null && splitDTOS.length > 0) {
			for (BaseDTO DTO : splitDTOS) {
				DTO.setAttrVal("Dt_last_mp", null);
			}
		}
	}

	/**
	 * 写日志信息(info)
	 * 
	 * @param msg
	 */
	public void log(String msg) {
		IMpNrLogService logService = ServiceFinder.find(IMpNrLogService.class);
		logService.log(msg + getNow(), Level.INFO);
	}

	/**
	 * 获取系统时间戳
	 * 
	 * @return
	 */
	public String getNow() {
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
		return format.format(date);
	}

}
