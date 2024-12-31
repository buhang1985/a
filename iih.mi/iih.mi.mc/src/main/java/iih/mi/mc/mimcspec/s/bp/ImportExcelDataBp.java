package iih.mi.mc.mimcspec.s.bp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import iih.bd.base.utils.DateTimeUtils;
import iih.bd.base.utils.SqlUtils;
import iih.bd.srv.bddsdef.d.BdDsDefDO;
import iih.bd.srv.bddsdef.i.IBddsdefRService;
import iih.bd.srv.diagdef.d.DiagDefDO;
import iih.bd.srv.diagdef.d.DiagdefAggDO;
import iih.bd.srv.diagdef.i.IDiagdefRService;
import iih.mi.mc.dto.d.MiMcPatSpecDTO;
import iih.mi.mc.mimcpatspec.d.MiMcPatSpecDO;
import iih.mi.mc.mimcpatspec.d.MiMcPatSpecDiDO;
import iih.mi.mc.mimcpatspec.d.MimcpatspecdiAggDO;
import iih.mi.mc.mimcpatspec.i.IMimcpatspecdiCudService;
import iih.mi.mc.mimcpatspec.i.IMimcpatspecdiRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 导入Excel数据
 * 
 * @author houll
 * @date 2019年9月18日
 * @version 1.0
 */
public class ImportExcelDataBp {

	@SuppressWarnings("unchecked")
	public void exec(MiMcPatSpecDTO[] miSpecdtoArr) throws BizException {
		if (ArrayUtil.isEmpty(miSpecdtoArr)) {
			return;
		}
		// 1.获取excel中患者对应的特殊病患者信息
		Map<String, MimcpatspecdiAggDO> patMap = this.getPatInfo(miSpecdtoArr);
		// 2.分组排序
		List<MiMcPatSpecDTO> tmpspecDtoList = new ArrayList<MiMcPatSpecDTO>();
		String tmpStr = "";
		for (MiMcPatSpecDTO miSpecDto : miSpecdtoArr) {
			String strPat = this.getFilterStr(miSpecDto);
			if (StringUtil.isEmpty(tmpStr))
				tmpStr = strPat;
			if (tmpStr.equals(strPat)) {
				tmpspecDtoList.add(miSpecDto);
			} else {
				if (patMap.containsKey(tmpStr)) {
					// 如果存在患者信息
					MimcpatspecdiAggDO miMcPatSpecDiDOArr = patMap.get(tmpStr);
					this.insertDO(tmpspecDtoList, miMcPatSpecDiDOArr);
				} else {
					// 如果不存在患者信息
					this.insertDO(tmpspecDtoList, null);
				}
				tmpspecDtoList = new ArrayList<MiMcPatSpecDTO>();
				tmpspecDtoList.add(miSpecDto);
				tmpStr = strPat;
			}
		}
		if (patMap.containsKey(tmpStr)) {
			// 如果存在患者信息
			MimcpatspecdiAggDO miMcPatSpecDiDOArr = patMap.get(tmpStr);
			this.insertDO(tmpspecDtoList, miMcPatSpecDiDOArr);
		} else {
			// 如果不存在患者信息
			this.insertDO(tmpspecDtoList, null);
		}
	}

	/**
	 * 插入患者医保信息
	 * 
	 * @param miSpecdto
	 * @throws BizException
	 */
	private void insertDO(List<MiMcPatSpecDTO> miSpecdtoList, MimcpatspecdiAggDO aggdo) throws BizException {
		MimcpatspecdiAggDO aggDO = new MimcpatspecdiAggDO();
		Map<String, BdDsDefDO> bdDsDefDoMap = getDsId(miSpecdtoList, aggdo);
		Map<String, DiagDefDO> diagDefDOMap = getDiId(miSpecdtoList, aggdo);
		List<MimcpatspecdiAggDO> aggDOList = new ArrayList<MimcpatspecdiAggDO>();

		List<MiMcPatSpecDiDO> specDiDOlist = new ArrayList<MiMcPatSpecDiDO>();
		MiMcPatSpecDO miMcPatSpecDO = null;
		for (MiMcPatSpecDTO miMcPatSpecDto : miSpecdtoList) {
			if (miMcPatSpecDO == null) {
				miMcPatSpecDO = new MiMcPatSpecDO();
				if (aggdo == null) {
					miMcPatSpecDO.setId_grp(Context.get().getGroupId());
					miMcPatSpecDO.setId_org(Context.get().getOrgId());
					miMcPatSpecDO.setId_hp(miMcPatSpecDto.getId_hp());
					miMcPatSpecDO.setNo_hp(miMcPatSpecDto.getNo_hp());
					miMcPatSpecDO.setName_pat(miMcPatSpecDto.getName_pat());
					miMcPatSpecDO.setSexname_pat(miMcPatSpecDto.getSexname_pat());
					miMcPatSpecDO.setTel_pat(miMcPatSpecDto.getTel_pat());
					miMcPatSpecDO.setStatus(DOStatus.NEW);
				} else {
					miMcPatSpecDO = aggdo.getParentDO();
					miMcPatSpecDO.setStatus(DOStatus.UPDATED);
				}
				aggDO.setParentDO(miMcPatSpecDO);
			}
			if (FBoolean.FALSE
					.equals(this.fExists(miMcPatSpecDto, aggdo != null ? aggdo.getMiMcPatSpecDiDO() : null))) {
				MiMcPatSpecDiDO patSpecDiDO = new MiMcPatSpecDiDO();
				if (bdDsDefDoMap != null && StringUtils.isNotEmpty(miMcPatSpecDto.getCode_ds()) && (bdDsDefDoMap.get(miMcPatSpecDto.getCode_ds()) != null)) {
					patSpecDiDO.setId_dsdef((bdDsDefDoMap.get(miMcPatSpecDto.getCode_ds()).getId_dsdef()));
				}
				if(diagDefDOMap!=null && StringUtils.isNotEmpty(miMcPatSpecDto.getCode_di())&& (diagDefDOMap.get(miMcPatSpecDto.getCode_di())!=null)){
					patSpecDiDO.setId_didef(diagDefDOMap.get(miMcPatSpecDto.getCode_di()).getId_didef());
				}
				patSpecDiDO.setCode_ds(miMcPatSpecDto.getCode_ds());
				patSpecDiDO.setNameds(miMcPatSpecDto.getName_ds());
				patSpecDiDO.setCode_di(miMcPatSpecDto.getCode_di());
				patSpecDiDO.setNamedi(miMcPatSpecDto.getName_di());
				patSpecDiDO.setDt_b(DateTimeUtils.getDayBeginTime(new FDateTime()));// 开始时间
				patSpecDiDO.setDt_e(new FDateTime("2099-12-31 23:59:59"));// 终止时间
				patSpecDiDO.setStatus(DOStatus.NEW);
				specDiDOlist.add(patSpecDiDO);
				aggDO.setMiMcPatSpecDiDO(specDiDOlist.toArray(new MiMcPatSpecDiDO[] {}));
			}
		}
		if (!ListUtil.isEmpty(specDiDOlist)) {
			aggDOList.add(aggDO);
			IMimcpatspecdiCudService specdiCudService = ServiceFinder.find(IMimcpatspecdiCudService.class);
			specdiCudService.save(aggDOList.toArray(new MimcpatspecdiAggDO[] {}));
		}

	}

	/**
	 * 判断导入数据在数据库中是否存在
	 * 
	 * @param miMcPatSpecDto
	 * @param miMcPatSpecDiDOList
	 * @return
	 */
	private FBoolean fExists(MiMcPatSpecDTO miMcPatSpecDto, MiMcPatSpecDiDO[] miMcPatSpecDiDOArr) {
		if (ArrayUtil.isEmpty(miMcPatSpecDiDOArr))
			return FBoolean.FALSE;
		for (MiMcPatSpecDiDO tmpdo : miMcPatSpecDiDOArr) {
			if ((!StringUtil.isEmpty(miMcPatSpecDto.getCode_ds())
					&& miMcPatSpecDto.getCode_ds().equals(tmpdo.getCode_ds()))
					|| (!StringUtil.isEmpty(miMcPatSpecDto.getCode_di())
							&& miMcPatSpecDto.getCode_di().equals(tmpdo.getCode_di()))) {
				return FBoolean.TRUE;
			}
		}
		return FBoolean.FALSE;
	}

	/**
	 * 获取特殊病患者信息(Excel中的患者)
	 * 
	 * @param miSpecdto
	 * @return
	 * @throws BizException
	 */
	private Map<String, MimcpatspecdiAggDO> getPatInfo(MiMcPatSpecDTO[] miSpecdto) throws BizException {
		Map<String, MimcpatspecdiAggDO> patMap = new HashMap<String, MimcpatspecdiAggDO>();
		List<String> patList = this.getExcelPatInfo(miSpecdto);
		if (ListUtil.isEmpty(patList))
			return null;
		StringBuilder sb = new StringBuilder();
		sb.append(SqlUtils.getInSqlByIds(" no_hp|| name_pat|| sexname_pat|| tel_pat ", patList));// 医保证件号码
		IMimcpatspecdiRService ser = ServiceFinder.find(IMimcpatspecdiRService.class);
		MimcpatspecdiAggDO[] mimcpatspecdiAggDOArr = ser.find(sb.toString(), "", FBoolean.FALSE);
		if (!ArrayUtil.isEmpty(mimcpatspecdiAggDOArr)) {
			for (MimcpatspecdiAggDO aggDo : mimcpatspecdiAggDOArr) {
				MiMcPatSpecDO miMcPatSpecDO = aggDo.getParentDO();
				String strPat = miMcPatSpecDO.getNo_hp() + miMcPatSpecDO.getName_pat() + miMcPatSpecDO.getSexname_pat()
						+ miMcPatSpecDO.getTel_pat();
				if (!patMap.containsKey(strPat))
					patMap.put(strPat, aggDo);
			}
		}
		return patMap;
	}

	/**
	 * 获取excel中的患者信息
	 * 
	 * @param miSpecdto
	 * @param patSpecMap
	 * @return
	 * @throws BizException
	 */
	private List<String> getExcelPatInfo(MiMcPatSpecDTO[] miSpecdto) throws BizException {
		List<String> patList = new ArrayList<String>();
		for (int i = 0; i < miSpecdto.length; i++) {
			MiMcPatSpecDTO miSpecDto = miSpecdto[i];
			String strPat = this.getFilterStr(miSpecDto);
			if (!patList.contains(strPat))
				patList.add(strPat);
		}
		return patList;
	}

	/**
	 * 获取过滤字段
	 * 
	 * @param miSpecdto
	 * @return
	 */
	private String getFilterStr(MiMcPatSpecDTO miSpecDto) {
		return miSpecDto.getNo_hp() + miSpecDto.getName_pat() + miSpecDto.getSexname_pat() + miSpecDto.getTel_pat();
	}

	/**
	 * 通过病种编码获取病种主键
	 * 
	 * @param aggdo
	 * @return
	 * @throws BizException
	 */
	private Map<String, BdDsDefDO> getDsId(List<MiMcPatSpecDTO> miSpecdtoList, MimcpatspecdiAggDO aggdo)
			throws BizException {
		Map<String, BdDsDefDO> patMap = new HashMap<String, BdDsDefDO>();

		List<String> listmeas = new ArrayList<String>();
		StringBuilder sbsql = new StringBuilder();
		sbsql.append(" code in (");
		if (aggdo != null) {
			MiMcPatSpecDiDO[] miMcPatSpecDido = aggdo.getMiMcPatSpecDiDO();
			for (MiMcPatSpecDiDO miMcPatSpecDiDo : miMcPatSpecDido) {
				if (StringUtils.isNotBlank(miMcPatSpecDiDo.getCode_ds()))
					listmeas.add(miMcPatSpecDiDo.getCode_ds());
			}
		} else {
			for (MiMcPatSpecDTO miSpecdto : miSpecdtoList) {
				if (StringUtils.isNotBlank(miSpecdto.getCode_ds()))
					listmeas.add(miSpecdto.getCode_ds());
			}
		}
		if (listmeas.size() > 0) {
			String douHao = "";
			for (String code : listmeas) {
				sbsql.append(douHao).append("'").append(code).append("'");
				douHao = ",";
			}
			sbsql.append(")");
			IBddsdefRService service = ServiceFinder.find(IBddsdefRService.class);
			BdDsDefDO[] bdDsDefDos = service.find(sbsql.toString(), "", FBoolean.FALSE);
			if (bdDsDefDos != null && bdDsDefDos.length > 0) {
				for (BdDsDefDO bdDsDefDO : bdDsDefDos) {
					if(!patMap.containsKey(bdDsDefDO.getCode())){
						patMap.put(bdDsDefDO.getCode(), bdDsDefDO);
					}
				}
			}
		}

		return patMap;
	}
	/**
	 * 通过诊断编码获取诊断主键
	 * 
	 * @param aggdo
	 * @return
	 * @throws BizException
	 */
	private Map<String, DiagDefDO> getDiId(List<MiMcPatSpecDTO> miSpecdtoList, MimcpatspecdiAggDO aggdo)
			throws BizException {
		Map<String, DiagDefDO> patMap = new HashMap<String, DiagDefDO>();

		List<String> listmeas = new ArrayList<String>();
		StringBuilder sbsql = new StringBuilder();
		sbsql.append(" code in (");
		if (aggdo != null) {
			MiMcPatSpecDiDO[] miMcPatSpecDido = aggdo.getMiMcPatSpecDiDO();
			for (MiMcPatSpecDiDO miMcPatSpecDiDo : miMcPatSpecDido) {
				if (StringUtils.isNotBlank(miMcPatSpecDiDo.getCode_di()))
					listmeas.add(miMcPatSpecDiDo.getCode_di());
			}
		} else {
			for (MiMcPatSpecDTO miSpecdto : miSpecdtoList) {
				if (StringUtils.isNotBlank(miSpecdto.getCode_di()))
					listmeas.add(miSpecdto.getCode_di());
			}
		}
		if (listmeas.size() > 0) {
			String douHao = "";
			for (String code : listmeas) {
				sbsql.append(douHao).append("'").append(code).append("'");
				douHao = ",";
			}
			sbsql.append(")");
			IDiagdefRService service = ServiceFinder.find(IDiagdefRService.class);
			DiagdefAggDO[] bdDIDefDos = service.find(sbsql.toString(), "", FBoolean.FALSE);
			for (DiagdefAggDO diagdefAggDO : bdDIDefDos) {
				DiagDefDO DiagDefDO=diagdefAggDO.getParentDO();
				if (DiagDefDO != null) {
						if(!patMap.containsKey(DiagDefDO.getCode())){
							patMap.put(DiagDefDO.getCode(), DiagDefDO);
					}
				}
			}
		
		}

		return patMap;
	}
	
}