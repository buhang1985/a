package iih.bd.pp.primd.s;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mysql.jdbc.StringUtils;

import iih.bd.pp.dto.d.BdSrvPriceDTO;
import iih.bd.pp.dto.d.PriSrvCompDTO;
import iih.bd.pp.dto.d.PriSrvSumDTO;
import iih.bd.pp.dto.d.PriStdSrvDTO;
import iih.bd.pp.dto.d.SrvPricalRateAndPriceDTO;
import iih.bd.pp.primd.bp.SrvPriCalSql;
import iih.bd.pp.primd.i.IBdPrimdCodeConst;
import iih.bd.pp.primd.i.IPriCalService;
import iih.bd.pp.primd.qry.PriPatSrvNotIncludedQry;
import iih.bd.pp.pripat.d.PriPatDO;
import iih.bd.pp.pripat.d.PriRateMdEnum;
import iih.bd.pp.pripat.i.IPripatMDORService;
import iih.bd.pp.prisrv.d.PriSrvDO;
import iih.bd.pp.prisrv.d.desc.PriSrvDODesc;
import iih.bd.pp.prisrvcomp.d.PriSrvCompDO;
import iih.bd.pp.prisrvcomp.d.desc.PriSrvCompDODesc;
import iih.bd.pp.prisrvcomp.i.IPrisrvcompRService;
import iih.bd.pp.prisrvsetfix.d.PriSrvSetFixDO;
import iih.bd.pp.prisrvsetfix.d.desc.PriSrvSetFixDODesc;
import iih.bd.pp.prisrvsetfix.i.IPrisrvsetfixRService;
import iih.bd.pp.prisrvsetmu.d.PriSrvSetMuDO;
import iih.bd.pp.prisrvsetmu.d.desc.PriSrvSetMuDODesc;
import iih.bd.pp.prisrvsetmu.i.IPrisrvsetmuRService;
import iih.bd.srv.dto.d.SrvSetItemDTO;
import iih.bd.srv.i.IBdSrvQryService;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedSrvSetItemDO;
import iih.bd.srv.medsrv.i.IMedSrvSetItemDORService;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.mm.itf.material.d.GetMaterialPriceDTO;
import iih.mm.itf.material.i.IMaterialBaseInfoService;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap;
import xap.mw.core.service.constant.Binding;
import xap.mw.core.service.time.TimeService;
import xap.mw.core.service.time.impl.TimeServiceImpl;
import xap.mw.core.utils.ListUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 价格计算服务操作方法服务实现
 * 
 * @author tcy
 *
 */
@Service(serviceInterfaces = { IPriCalService.class }, binding = Binding.JSONRPC)
public class PriCalServiceImpl implements IPriCalService {

	/**
	 * 用bd_pri_srv中的价格同步bd_srv中的pri
	 * 
	 * @param bdSrvPriceDTOArr
	 *            待同步的bd_srv的信息
	 * @return 需要同步的<id_srv,价格>
	 * @throws BizException
	 */
	public Map<String, FDouble> bdsrvPriceSynchronization(BdSrvPriceDTO[] bdSrvPriceDTOArr) throws BizException {
		TimeService timeService = new TimeServiceImpl();
		String strDateTime = timeService.getUFDateTime().toStdString();
		FDouble price = new FDouble(0);
		Map<String, FDouble> diffPriceMap = new HashMap<String, FDouble>();
		Map<String, FDouble> tempPriceMap = new HashMap<String, FDouble>();
		for (BdSrvPriceDTO bdSrvPriceDTO : bdSrvPriceDTOArr) {
			price = new FDouble(0);
			if (tempPriceMap.containsKey(bdSrvPriceDTO.getId_srv())) {
				price = tempPriceMap.get(bdSrvPriceDTO.getId_srv()); // 服务套或组合定价中需要重复出现的服务及其价格
			} else {
				// price=CalSrvStdPriceEngine(bdSrvPriceDTO.getId_srv(),
				// bdSrvPriceDTO.getId_primd(), strDateTime);
				PriStdSrvDTO[] priStdSrvDTOArr = CalSrvStdPriceDTOEngine(bdSrvPriceDTO.getId_srv(), bdSrvPriceDTO.getId_primd(), strDateTime);
				for (PriStdSrvDTO priStdSrvDTO : priStdSrvDTOArr) {
					if (priStdSrvDTO.getQuan() == null) {
						price = price.add(priStdSrvDTO.getPrice());// 本服务定价
					} else {
						price = price.add(priStdSrvDTO.getPrice().multiply(priStdSrvDTO.getQuan())); // 组合计价或成员合计价
					}
				}
				tempPriceMap.put(bdSrvPriceDTO.getId_srv(), price);
			}
			if (price.compareTo(bdSrvPriceDTO.getPrice()) != 0) {
				diffPriceMap.put(bdSrvPriceDTO.getId_srv(), price);
			}
		}
		return diffPriceMap;
	}

	/**
	 * 计价引擎，根据服务的定价模式，计算服务价格
	 * 
	 * @param primdId
	 *            定价模式ID
	 * @param srvId
	 *            服务ID
	 * @return 返回价格
	 */
	private FDouble CalSrvStdPriceEngine(String Id_srv, String id_primd, String strDateTime) throws BizException {
		Object result = null;
		FDouble price = new FDouble(0);
		SrvPriCalSql srvPriCalSql = new SrvPriCalSql();
		List<PriStdSrvDTO> priStdSrvDTOLst = new ArrayList<PriStdSrvDTO>();
		PriStdSrvDTO[] priStdSrvDTOArr = null;
		if (StringUtils.isNullOrEmpty(id_primd)) {
			throw new BizException("该服务计价模式未定义。\r\n 服务ID: " + Id_srv);
		}
		if (id_primd.equals(IBdPrimdCodeConst.ID_PRI_SRV)) // 本服务定价
		{
			ColumnHandler handler = new ColumnHandler();
			String sql = srvPriCalSql.Get_Single_PRISRV_Sql();
			SqlParam sqlParam = new SqlParam();
			// sqlParam.addParam(strDateTime);
			// sqlParam.addParam(strDateTime);
			sqlParam.addParam(Id_srv);
			// sqlParam.addParam(Id_srv);
			DAFacade cade = new DAFacade();
			result = cade.execQuery(sql, sqlParam, handler);
			if (result == null) {
				throw new BizException("该服务不存在或不存在当前价格,服务ID: " + Id_srv);
			}
			price = new FDouble(result.toString());
		} else if (id_primd.equals(IBdPrimdCodeConst.ID_PRI_PLUGIN)) {
			// 采用外挂的定价模式

			// 目前为了程序不报错而写
			return new FDouble(0);
		} else if (id_primd.equals(IBdPrimdCodeConst.ID_PRI_SRVSET_AMOUNT)) // 服务套成员合计价
		{
			priStdSrvDTOArr = this.CalSrvSetSumPrice(Id_srv);
		} else if (id_primd.equals(IBdPrimdCodeConst.ID_PRI_SRV_COMP)) // 组合计价
		{
			priStdSrvDTOArr = this.CalSrvCompPrice(Id_srv);
		} else {
			throw new BizException("该服务未在  本服务定价模式或外挂定价模式  中定价。\r\n 服务ID: " + Id_srv);
		}
		if (priStdSrvDTOArr != null && priStdSrvDTOArr.length > 0) {
			for (PriStdSrvDTO priStdSrvDTO : priStdSrvDTOArr) {
				if (priStdSrvDTO.getPrice() != null && priStdSrvDTO.getQuan() != null) {
					price = price.add(priStdSrvDTO.getPrice().multiply(priStdSrvDTO.getQuan()));
				}
			}
		}

		return price;
	}

	/**
	 * 计价引擎，根据服务和定价模式，计算服务价格
	 * 
	 * @param primdId
	 *            定价模式ID
	 * @param srvId
	 *            服务ID
	 * @return 返回价格DTO
	 */
	public PriStdSrvDTO[] CalSrvStdPriceDTOEngine(String Id_srv, String id_primd, String strDateTime) throws BizException {
		Object result = null;
		FDouble price = new FDouble(0);
		SrvPriCalSql srvPriCalSql = new SrvPriCalSql();
		List<PriStdSrvDTO> priStdSrvDTOLst = new ArrayList<PriStdSrvDTO>();
		PriStdSrvDTO[] priStdSrvDTOArr = null;
		if (StringUtils.isNullOrEmpty(id_primd)) {
			throw new BizException("该服务计价模式未定义。\r\n 服务ID: " + Id_srv);
		}
		if (id_primd.equals(IBdPrimdCodeConst.ID_PRI_SRV)) // 本服务定价
		{
			ColumnHandler handler = new ColumnHandler();
			String sql = srvPriCalSql.Get_Single_PRISRV_Sql();
			SqlParam sqlParam = new SqlParam();
			// sqlParam.addParam(strDateTime);
			// sqlParam.addParam(strDateTime);
			sqlParam.addParam(Id_srv);
			// sqlParam.addParam(Id_srv);
			DAFacade cade = new DAFacade();
			result = cade.execQuery(sql, sqlParam, handler);
			if (result == null) {
				throw new BizException("该服务不存在或不存在当前价格,服务ID: " + Id_srv);
			}
			price = new FDouble(result.toString());
			PriStdSrvDTO priStdSrvDTO = new PriStdSrvDTO();
			priStdSrvDTO.setId_srv(Id_srv);
			priStdSrvDTO.setPrice(price);
			priStdSrvDTOArr = new PriStdSrvDTO[] { priStdSrvDTO };

		} else if (id_primd.equals(IBdPrimdCodeConst.ID_PRI_PLUGIN)) {
			// 采用外挂的定价模式

			// 目前为了程序不报错而写
			return null;
		} else if (id_primd.equals(IBdPrimdCodeConst.ID_PRI_SRVSET_AMOUNT)) // 服务套成员合计价
		{
			priStdSrvDTOArr = this.CalSrvSetSumPrice(Id_srv);
		} else if (id_primd.equals(IBdPrimdCodeConst.ID_PRI_SRV_COMP)) // 组合计价
		{
			priStdSrvDTOArr = this.CalSrvCompPrice(Id_srv);
		} else {
			throw new BizException("该服务未在  本服务定价模式、组合计价、服务套成员合计价或外挂定价模式  中定价。\r\n 服务ID: " + Id_srv);
		}

		return priStdSrvDTOArr;
	}

	/**
	 * 计算单个服务标准价格(本服务定价)
	 * 
	 * @param primdId
	 *            定价模式ID
	 * @param srvId
	 *            服务ID
	 * @return 返回价格
	 */
	public FDouble CalSingleSrvStdPrice(String Id_srv) throws BizException {

		SrvPriCalSql srvPriCalSql = new SrvPriCalSql();
		TimeService timeService = new TimeServiceImpl();

		String strDateTime = timeService.getUFDateTime().toStdString();
		Object result = null;
		// 判断该服务采用何种定价模式
		String[] fields = { "Id_primd" };
		DAFacade dafacade = new DAFacade();
		List<MedSrvDO> medSrvDO = (List<MedSrvDO>) dafacade.findByCond(MedSrvDO.class, " id_srv='" + Id_srv + "'", fields);
		if (medSrvDO == null || medSrvDO.size() == 0) {
			throw new BizException("该服务不存在。\r\n 服务ID: " + Id_srv);
		}

		String id_primd = medSrvDO.get(0).getId_primd();

		if (StringUtils.isNullOrEmpty(id_primd)) {
			throw new BizException("该服务计价模式未定义。\r\n 服务ID: " + Id_srv);
		}
		if (id_primd.equals(IBdPrimdCodeConst.ID_PRI_SRV)) {
			ColumnHandler handler = new ColumnHandler();
			String sql = srvPriCalSql.Get_Single_PRISRV_Sql();
			SqlParam sqlParam = new SqlParam();
			// sqlParam.addParam(strDateTime);
			// sqlParam.addParam(strDateTime);
			sqlParam.addParam(Id_srv);
			// sqlParam.addParam(Id_srv);
			DAFacade cade = new DAFacade();
			result = cade.execQuery(sql, sqlParam, handler);
			if (result == null) {
				throw new BizException("该服务不存在或不存在当前价格,服务ID: " + Id_srv);
			}
		} else if (id_primd.equals(IBdPrimdCodeConst.ID_PRI_PLUGIN)) {
			// 采用外挂的定价模式

			// 目前为了程序不报错而写
			return new FDouble(0);
		} else {
			throw new BizException("传入参数有误，不是价表项目。\r\n 服务ID: " + Id_srv);
			// throw new
			// BizException("该服务未在  本服务定价模式或外挂定价模式  中定价。\r\n 服务ID: "+Id_srv);
		}
		return new FDouble((BigDecimal) result);
	}

	/**
	 * 计算单个服务标准价格,如果没有查询到结果，则提示：该服务不存在或不存在当前价格。服务名称：***
	 * 
	 * @param primdId
	 *            定价模式ID
	 * @param srvId
	 *            服务ID
	 * @return 返回价格
	 */
	public FDouble CalSingleSrvStdPrice_NameTip(String Id_srv, String Name_srv) throws BizException {

		SrvPriCalSql srvPriCalSql = new SrvPriCalSql();
		TimeService timeService = new TimeServiceImpl();
		String strDateTime = timeService.getUFDateTime().toStdString();
		Object result = null;
		// 判断该服务采用何种定价模式
		String[] fields = { "Id_primd" };
		DAFacade dafacade = new DAFacade();
		List<MedSrvDO> medSrvDO = (List<MedSrvDO>) dafacade.findByCond(MedSrvDO.class, " id_srv='" + Id_srv + "'", fields);
		if (medSrvDO == null || medSrvDO.size() == 0) {
			throw new BizException("该服务不存在 。\r\n服务名称：" + Name_srv + "。\r\n 服务ID: " + Id_srv);
		}

		String id_primd = medSrvDO.get(0).getId_primd();
		if (id_primd == null) {
			throw new BizException("该服务计价模式未定义。\r\n服务名称：" + Name_srv + "。\r\n 服务ID: " + Id_srv);
		}
		if (id_primd.equals(IBdPrimdCodeConst.ID_PRI_SRV)) {
			// 采用本服务定价
			ColumnHandler handler = new ColumnHandler();
			String sql = srvPriCalSql.Get_Single_PRISRV_Sql();
			SqlParam sqlParam = new SqlParam();
			// sqlParam.addParam(strDateTime);
			// sqlParam.addParam(strDateTime);
			sqlParam.addParam(Id_srv);
			// sqlParam.addParam(Id_srv);
			DAFacade cade = new DAFacade();
			result = cade.execQuery(sql, sqlParam, handler);
			if (result == null) {
				if (Name_srv == null) {
					List<MedSrvDO> medSrvDO1 = (List<MedSrvDO>) cade.findByCond(MedSrvDO.class, " id_srv='" + Id_srv + "' ", new String[] { "name" });
					if (medSrvDO1 != null && medSrvDO1.size() > 0) {
						Name_srv = medSrvDO1.toArray(new MedSrvDO[0])[0].getName();
					}
				}

				throw new BizException("未查询到该服务价格。\r\n服务名称：" + Name_srv + "。\r\n 服务ID: " + Id_srv + "\r\n请检查服务定价！");
			}
		} else if (id_primd.equals(IBdPrimdCodeConst.ID_PRI_PLUGIN)) {
			// 采用外挂的定价模式

			// 为了不报错
			return new FDouble(0);
		} else {
			if (Name_srv == null) {
				DAFacade cade = new DAFacade();
				List<MedSrvDO> medSrvDO1 = (List<MedSrvDO>) cade.findByCond(MedSrvDO.class, " id_srv='" + Id_srv + "' ", new String[] { "name" });
				if (medSrvDO1 != null && medSrvDO1.size() > 0) {
					Name_srv = medSrvDO1.toArray(new MedSrvDO[0])[0].getName();
				}
			}
			throw new BizException("传入参数有误，不是价表项目。\r\n服务名称：" + Name_srv + "。\r\n 服务ID: " + Id_srv);
		}
		return new FDouble((BigDecimal) result);
	}

	/**
	 * 在价格分类基础上计算单个服务价格,如果没有查询到结果，则抛出
	 * 
	 * @param Id_srv
	 *            服务ID
	 * @param Name_srv
	 *            服务名称
	 * @param priPatDO
	 *            患者价格分类
	 * @param SrvPricalRateDTO
	 *            服务计价比例和单价DTO
	 * @return 返回价格
	 */
	public SrvPricalRateAndPriceDTO CalSingleSrvPriceByIdPripat_NameTip(String Id_srv, String Name_srv, String id_pripat) throws BizException {
		// FDouble price=new FDouble(0);//价格=标准价格*价格分类比例
		// 1.查改价格分类下对应的默认比例
		SrvPricalRateAndPriceDTO srvPricalRateAndPriceDTO = new SrvPricalRateAndPriceDTO();
		String[] fields = { "Id_pripat", "Eu_pi_pricamd", "Rate" };
		DAFacade dAFacade = new DAFacade();
		List<PriPatDO> priPatDOList = (List<PriPatDO>) dAFacade.findByCond(PriPatDO.class, " Id_pripat='" + id_pripat + "' ", "1", fields);
		// 查询价格分类
		// String
		// condstr=" "+PriPatDODesc.TABLE_ALIAS_NAME+".Id_pripat='"+id_pripat+"' ";
		// IPripatMDORService
		// iPripatMDORService=ServiceFinder.find(IPripatMDORService.class);
		// PriPatDO[] priPatDO=iPripatMDORService.find(condstr, "",
		// FBoolean.FALSE);
		// if(priPatDOList==null)
		if (ListUtil.isEmpty(priPatDOList) || priPatDOList.size() == 0) {
			throw new BizException("没有找到患者就诊对应的价格分类 ！");
		}
		// srvPricalRateAndPriceDTO=CalSingleSrvPriceByIdPripatx_NameTip(Id_srv,Name_srv,priPatDOList.toArray(new
		// PriPatDO[]{})[0],null);
		srvPricalRateAndPriceDTO = CalSingleSrvPriceByIdPripatx_New_NameTip(Id_srv, Name_srv, priPatDOList.toArray(new PriPatDO[] {})[0], null);
		
		return srvPricalRateAndPriceDTO;
	}

	/**
	 * 在价格分类基础上计算单个服务价格,如果没有查询到结果，则抛出
	 * 
	 * @param Id_srv
	 *            服务ID
	 * @param Name_srv
	 *            服务名称
	 * @param priPatDO
	 *            患者价格分类
	 * @param SrvPricalRateDTO
	 *            服务计价比例和单价DTO
	 * @return 返回价格
	 */
	public SrvPricalRateAndPriceDTO CalSingleSrvPriceByIdPripat_NameTip_withoutThrow(String Id_srv, String Name_srv, String id_pripat) throws BizException {
		// FDouble price=new FDouble(0);//价格=标准价格*价格分类比例
		// 1.查改价格分类下对应的默认比例
		SrvPricalRateAndPriceDTO srvPricalRateAndPriceDTO = new SrvPricalRateAndPriceDTO();
		String[] fields = { "Id_pripat", "Eu_pi_pricamd", "Rate" };
		DAFacade dAFacade = new DAFacade();
		List<PriPatDO> priPatDOList = (List<PriPatDO>) dAFacade.findByCond(PriPatDO.class, " Id_pripat='" + id_pripat + "' ", "1", fields);
		// 查询价格分类
		// String
		// condstr=" "+PriPatDODesc.TABLE_ALIAS_NAME+".Id_pripat='"+id_pripat+"' ";
		// IPripatMDORService
		// iPripatMDORService=ServiceFinder.find(IPripatMDORService.class);
		// PriPatDO[] priPatDO=iPripatMDORService.find(condstr, "",
		// FBoolean.FALSE);
		// if(priPatDOList==null)
		if (ListUtil.isEmpty(priPatDOList) || priPatDOList.size() == 0) {
			// throw new BizException("没有找到患者就诊对应的价格分类 ！");
			srvPricalRateAndPriceDTO.setId_srv(Id_srv);
			srvPricalRateAndPriceDTO.setError_msg("没有找到患者就诊对应的价格分类 ！");
			return srvPricalRateAndPriceDTO;
		}
		// srvPricalRateAndPriceDTO=CalSingleSrvPriceByIdPripatx_NameTip(Id_srv,Name_srv,priPatDOList.toArray(new
		// PriPatDO[]{})[0],null);
		srvPricalRateAndPriceDTO = CalSingleSrvPriceByIdPripatx_New_NameTip_withoutThrow(Id_srv, Name_srv, priPatDOList.toArray(new PriPatDO[] {})[0], null);
		return srvPricalRateAndPriceDTO;
	}

	/**
	 * 在价格分类基础上计算单个服务价格,如果没有查询到结果，
	 * 
	 * @param Id_srv
	 *            服务ID
	 * @param Name_srv
	 *            服务名称
	 * @param priPatDO
	 *            患者价格分类
	 * @param SrvPricalRateDTO_arr
	 *            服务计价比例DTO
	 * @return
	 * @throws BizException
	 */
	private SrvPricalRateAndPriceDTO CalSingleSrvPriceByIdPripatx_New_NameTip(String Id_srv, String Name_srv, PriPatDO priPatDO, SrvPricalRateAndPriceDTO[] SrvPricalRateDTO_arr) throws BizException {
		FDouble stdPrice = new FDouble(0); // 定义标准价格
		FDouble price = null;// 价格=标准价格*价格分类比例
		SrvPricalRateAndPriceDTO srvPricalRateAndPriceDTO = new SrvPricalRateAndPriceDTO();

		if (StringUtils.isNullOrEmpty(Id_srv)) {
			throw new BizException("服务ID为空！");
		}
		// 1.获得标准价格
		stdPrice = CalSingleSrvStdPrice_NameTip(Id_srv, Name_srv);
		// 标准价格
		srvPricalRateAndPriceDTO.setPrice(stdPrice); // 标准价格
		// 2.查询价格分类
		if (priPatDO == null) {
			throw new BizException("没有找到患者就诊对应的价格分类！");
		}
		FDouble rate = priPatDO.getRate();// 定义计算比例
		// 3.获得价格分类下的特殊项目
		if (SrvPricalRateDTO_arr == null) {
			// 患者价格分类维护时是项目排除原则，如果维护了服务项目，代表该项目不采用患者价格分类对应的价格比例
			SrvPricalRateDTO_arr = GetAllSrvRatelByIdPripat(priPatDO.getId_pripat());
		}

		// review by yangyang 2017-02-22 如果查询出有特殊项目需要排除，则走下边逻辑
		// for(int ii=0;ii<SrvPricalRateDTO_arr.length;ii++)
		// {
		// if(Id_srv.equals(SrvPricalRateDTO_arr[ii].getId_srv()))
		// {
		// if(SrvPricalRateDTO_arr[ii].getPrice()!=null)
		// {
		// price=SrvPricalRateDTO_arr[ii].getPrice();
		// rate=new FDouble(1);
		// }
		// else
		// {
		// rate=SrvPricalRateDTO_arr[ii].getRate();
		// }
		// break;
		// }
		// }
		for (SrvPricalRateAndPriceDTO item : SrvPricalRateDTO_arr) {
			if (Id_srv.equals(item.getId_srv())) {
				if (PriRateMdEnum.PRIRATIOMODEL.equals(item.getEu_pi_priratemd())) {
					// 比例模式
					rate = new FDouble(item.getRate());
				} else {
					if (item.getPri() != null) {
						stdPrice = item.getPri();
						rate = new FDouble(1);
					}
				}
				break;
			}
		}
		srvPricalRateAndPriceDTO.setRate(rate);
		srvPricalRateAndPriceDTO.setId_srv(Id_srv);
		// 价格=标准价格*价格分类比例
		srvPricalRateAndPriceDTO.setPrice_ratio(stdPrice.multiply(rate).setScale(-4, BigDecimal.ROUND_HALF_UP)); // 折扣价格
		return srvPricalRateAndPriceDTO;
	}

	/**
	 * 在价格分类基础上计算单个服务价格,如果没有查询到结果，返回的DTO中Error_msg有描述原因
	 * 
	 * @param Id_srv
	 *            服务ID
	 * @param Name_srv
	 *            服务名称
	 * @param priPatDO
	 *            患者价格分类
	 * @param SrvPricalRateDTO_arr
	 *            服务计价比例DTO
	 * @return
	 * @throws BizException
	 */
	private SrvPricalRateAndPriceDTO CalSingleSrvPriceByIdPripatx_New_NameTip_withoutThrow(String Id_srv, String Name_srv, PriPatDO priPatDO, SrvPricalRateAndPriceDTO[] SrvPricalRateDTO_arr) throws BizException {
		FDouble stdPrice = new FDouble(0); // 定义标准价格
		FDouble price = null;// 价格=标准价格*价格分类比例
		SrvPricalRateAndPriceDTO srvPricalRateAndPriceDTO = new SrvPricalRateAndPriceDTO();

		if (StringUtils.isNullOrEmpty(Id_srv)) {
			// throw new BizException("服务ID为空！");
			srvPricalRateAndPriceDTO.setId_srv(Id_srv);
			srvPricalRateAndPriceDTO.setError_msg("服务ID为空！");
			return srvPricalRateAndPriceDTO;
		}
		// 1.获得标准价格
		stdPrice = CalSingleSrvStdPrice_NameTip(Id_srv, Name_srv);
		// 标准价格
		srvPricalRateAndPriceDTO.setPrice(stdPrice); // 标准价格
		// 2.查询价格分类
		if (priPatDO == null) {
			// throw new BizException("没有找到患者就诊对应的价格分类！");
			srvPricalRateAndPriceDTO.setId_srv(Id_srv);
			srvPricalRateAndPriceDTO.setError_msg("没有找到患者就诊对应的价格分类！");
			return srvPricalRateAndPriceDTO;
		}
		FDouble rate = priPatDO.getRate();// 定义计算比例
		// 3.获得价格分类下的特殊项目
		if (SrvPricalRateDTO_arr == null) {
			// 患者价格分类维护时是项目排除原则，如果维护了服务项目，代表该项目不采用患者价格分类对应的价格比例
			SrvPricalRateDTO_arr = GetAllSrvRatelByIdPripat(priPatDO.getId_pripat());
		}

		// review by yangyang 2017-02-22 如果查询出有特殊项目需要排除，则走下边逻辑
		// for(int ii=0;ii<SrvPricalRateDTO_arr.length;ii++)
		// {
		// if(Id_srv.equals(SrvPricalRateDTO_arr[ii].getId_srv()))
		// {
		// if(SrvPricalRateDTO_arr[ii].getPrice()!=null)
		// {
		// price=SrvPricalRateDTO_arr[ii].getPrice();
		// rate=new FDouble(1);
		// }
		// else
		// {
		// rate=SrvPricalRateDTO_arr[ii].getRate();
		// }
		// break;
		// }
		// }
		for (SrvPricalRateAndPriceDTO item : SrvPricalRateDTO_arr) {
			if (Id_srv.equals(item.getId_srv())) {
				if (PriRateMdEnum.PRIRATIOMODEL.equals(item.getEu_pi_priratemd())) {
					// 比例模式
					rate = new FDouble(item.getRate());
				} else {
					if (item.getPri() != null) {
						stdPrice = item.getPri();
						rate = new FDouble(1);
					}
				}
				break;
			}
		}
		srvPricalRateAndPriceDTO.setRate(rate);
		srvPricalRateAndPriceDTO.setId_srv(Id_srv);
		// 价格=标准价格*价格分类比例
		srvPricalRateAndPriceDTO.setPrice_ratio(stdPrice.multiply(rate).setScale(-4, BigDecimal.ROUND_HALF_UP)); // 折扣价格
		return srvPricalRateAndPriceDTO;
	}

	// /**
	// * 在价格分类基础上计算单个服务价格,如果没有查询到结果，
	// * @param Id_srv 服务ID
	// * @param Name_srv 服务名称
	// * @param priPatDO 患者价格分类
	// * @param SrvPricalRateDTO_arr 服务计价比例DTO
	// * @return
	// * @throws BizException
	// */
	// private SrvPricalRateAndPriceDTO CalSingleSrvPriceByIdPripatx_NameTip(
	// String Id_srv,String Name_srv,PriPatDO
	// priPatDO,SrvPricalRateAndPriceDTO[] SrvPricalRateDTO_arr ) throws
	// BizException
	// {
	// FDouble stdPrice=new FDouble(0); //定义标准价格
	// FDouble rate=null;//定义计算比例
	// FDouble price=new FDouble(0);//价格=标准价格*价格分类比例
	// SrvPricalRateAndPriceDTO srvPricalRateAndPriceDTO=new
	// SrvPricalRateAndPriceDTO();
	//
	// if(("").equals(Id_srv))
	// {
	// throw new BizException("服务ID为空！");
	// }
	// //1.获得标准价格
	// stdPrice=CalSingleSrvStdPrice_NameTip(Id_srv,Name_srv);
	// //2.查询价格分类
	// if(priPatDO==null)
	// {
	// throw new BizException("没有找到患者就诊对应的价格分类！");
	// }
	// if(priPatDO.getEu_pi_pricamd()==null)
	// {
	// throw new
	// BizException("未定义价格分类模式，查询患者就诊对应的价格分类表失败。\r\n价格分类主键："+priPatDO.getId_pripat());
	// }
	// //先找特殊的，没有特殊的找通用比例
	// if(SrvPricalRateDTO_arr==null)
	// {
	// rate=GetSingleSrvRateByIdPripat(Id_srv,priPatDO.getId_pripat());
	// }
	// else
	// {
	// for(int ii=0;ii<SrvPricalRateDTO_arr.length;ii++)
	// {
	// if(Id_srv.equals(SrvPricalRateDTO_arr[ii].getId_srv()))
	// {
	// rate=SrvPricalRateDTO_arr[ii].getRate();
	// break;
	// }
	// }
	// }
	// if(rate==null)//没有特殊的找通用比例
	// {
	// rate=priPatDO.getRate();
	// }
	//
	// // if(priPatDO.getEu_pi_pricamd().equals(0))//患者价格分类
	// // {
	// // rate=priPatDO.getRate();
	// // }
	// // else if(priPatDO.getEu_pi_pricamd().equals(1))//服务定制
	// // {
	// //
	// // if(SrvPricalRateDTO_arr==null)
	// // {
	// // rate=GetSingleSrvRateByIdPripat(Id_srv,priPatDO.getId_pripat());
	// //
	// // }
	// // else
	// // {
	// // for(int ii=0;ii<SrvPricalRateDTO_arr.length;ii++)
	// // {
	// // if(Id_srv.equals(SrvPricalRateDTO_arr[ii].getId_srv()))
	// // {
	// // rate=SrvPricalRateDTO_arr[ii].getRate();
	// // break;
	// // }
	// // }
	// // }
	// // }
	// srvPricalRateAndPriceDTO.setRate(rate);
	// srvPricalRateAndPriceDTO.setPrice(stdPrice);
	// srvPricalRateAndPriceDTO.setId_srv(Id_srv);
	//
	// return srvPricalRateAndPriceDTO;
	// }

	/**
	 * 计算多种价格分类下，指定服务的价格(CI调用）
	 * 
	 * @param pricalSrvDTO
	 *            待计价服务数组（id_srv,id_name)
	 * @param id_pripats
	 *            价格分类
	 * @return <
	 * @throws BizException
	 */
	public Map<String, SrvPricalRateAndPriceDTO[]> CalManySrvsPriceMapByIdPripats(PriStdSrvDTO[] pricalSrvDTO, String[] id_pripats) throws BizException {
		Map<String, SrvPricalRateAndPriceDTO[]> idpripat_srvsmap = new HashMap<String, SrvPricalRateAndPriceDTO[]>();
		if (id_pripats == null || id_pripats.length > 0) {
			throw new BizException("没有价格分类");
		}
		for (int i = 0; i < id_pripats.length; i++) {
			idpripat_srvsmap.put(id_pripats[i], CalManySrvsPriceMapByIdPripat(pricalSrvDTO, id_pripats[i]));
		}
		if (idpripat_srvsmap == null || idpripat_srvsmap.size() == 0) {
			throw new BizException("没有检索到价格数据");
		}
		return idpripat_srvsmap;
	}

	/**
	 * 计算多种价格分类下，指定服务的价格(CI调用）
	 * 
	 * @param pricalSrvDTO
	 *            待计价服务数组（id_srv,id_name)
	 * @param id_pripats
	 *            价格分类
	 * @return <
	 * @throws BizException
	 */
	public Map<String, SrvPricalRateAndPriceDTO[]> CalManySrvsPriceMapByIdPripats_withThrow(PriStdSrvDTO[] pricalSrvDTO, String[] id_pripats) throws BizException {
		Map<String, SrvPricalRateAndPriceDTO[]> idpripat_srvsmap = new HashMap<String, SrvPricalRateAndPriceDTO[]>();
		if (id_pripats == null || id_pripats.length > 0) {
			throw new BizException("没有价格分类");
		}
		for (int i = 0; i < id_pripats.length; i++) {
			idpripat_srvsmap.put(id_pripats[i], CalManySrvsPriceMapByIdPripat(pricalSrvDTO, id_pripats[i]));
		}
		if (idpripat_srvsmap == null || idpripat_srvsmap.size() == 0) {
			throw new BizException("没有检索到价格数据");
		}
		return idpripat_srvsmap;
	}

	/**
	 * CI折扣价：批量查询
	 * 
	 * @param pricalSrvDTO
	 *            <价格分类，<入参idsrv,<本服务定价ID_SRV或组合定价ID_SRV,价格信息>>>
	 * @return
	 * @throws BizException
	 */
	public Map<String, Map<String, Map<String, SrvPricalRateAndPriceDTO>>> calSrvPriUnderPripatsBatch(PriStdSrvDTO[] pricalSrvDTOs) throws BizException {
		Object result = null;
		FDouble price = new FDouble(0);
		SrvPriCalSql srvPriCalSql = new SrvPriCalSql();
		// List<PriStdSrvDTO> priStdSrvDTOLst=new ArrayList<PriStdSrvDTO>();
		PriStdSrvDTO[] priStdSrvDTOArr = null;
		String id_pripat = "";
		String id_primd = "";
		String id_srv = "";
		String name = "";
		int num = 0;
		Map<String, Map<String, SrvPricalRateAndPriceDTO>> map = new HashMap<String, Map<String, SrvPricalRateAndPriceDTO>>();
		Map<String, Map<String, Map<String, SrvPricalRateAndPriceDTO>>> idpripat_map = new HashMap<String, Map<String, Map<String, SrvPricalRateAndPriceDTO>>>();
		List<MedSrvDO> medSrvDOLst = null;
		// 1.空校验
		if (pricalSrvDTOs == null || pricalSrvDTOs.length == 0) {
			Map<String, SrvPricalRateAndPriceDTO> temp = new HashMap<String, SrvPricalRateAndPriceDTO>();
			SrvPricalRateAndPriceDTO dto = new SrvPricalRateAndPriceDTO();
			dto.setId_srv("");
			dto.setError_msg("参数为空！");
			temp.put("", dto);
			map.put("", temp);
			idpripat_map.put("", map);
		}
		// 2.检索所有价格分类
		String[] fields = { "id_pripat" };
		String[] fields1 = { "id_primd", "id_srv", "name" };
		DAFacade dafacade = new DAFacade();
		List<PriPatDO> priPatDOLst = (List<PriPatDO>) dafacade.findByCond(PriPatDO.class, " 1=1", fields);
		if (priPatDOLst == null || priPatDOLst.size() == 0) {
			Map<String, SrvPricalRateAndPriceDTO> temp = new HashMap<String, SrvPricalRateAndPriceDTO>();
			SrvPricalRateAndPriceDTO dto = new SrvPricalRateAndPriceDTO();
			dto.setId_srv("");
			dto.setError_msg("价格分类为空！");
			temp.put("", dto);
			map.put("", temp);
			idpripat_map.put("", map);
		}
		// 3.循环计算每个价格分类下的服务折扣价
		for (PriPatDO priPatDO : priPatDOLst) {
			for (PriStdSrvDTO priStdSrvDTO : pricalSrvDTOs) {
				map = new HashMap<String, Map<String, SrvPricalRateAndPriceDTO>>();
				// 3.1获取服务对应的定价模式
				id_srv = priStdSrvDTO.getId_srv();
				id_pripat = priPatDO.getId_pripat();
				medSrvDOLst = (List<MedSrvDO>) dafacade.findByCond(MedSrvDO.class, " id_srv='" + priStdSrvDTO.getId_srv() + "'", fields1);
				if (medSrvDOLst == null || medSrvDOLst.size() == 0) {
					Map<String, SrvPricalRateAndPriceDTO> temp = new HashMap<String, SrvPricalRateAndPriceDTO>();
					SrvPricalRateAndPriceDTO dto = new SrvPricalRateAndPriceDTO();
					dto.setId_srv(id_srv);
					dto.setError_msg("定价模式为空！");
					temp.put(id_srv, dto);
					map.put(id_srv, temp);
				}
				id_primd = medSrvDOLst.toArray(new MedSrvDO[0])[0].getId_primd();
				name = medSrvDOLst.toArray(new MedSrvDO[0])[0].getName();
				if (id_primd.equals(IBdPrimdCodeConst.ID_PRI_SRV)) // 本服务定价
				{
					SrvPricalRateAndPriceDTO srvPricalRateAndPriceDTO = CalSingleSrvPriceByIdPripat_NameTip_withoutThrow(id_srv, name, id_pripat);
					Map<String, SrvPricalRateAndPriceDTO> temp = new HashMap<String, SrvPricalRateAndPriceDTO>();
					temp.put(priStdSrvDTO.getId_srv(), srvPricalRateAndPriceDTO);
					map.put(id_srv, temp);
				} else if (id_primd.equals(IBdPrimdCodeConst.ID_PRI_PLUGIN)) // 外挂的定价模式
				{
					// 采用外挂的定价模式

					// 目前为了程序不报错而写
					Map<String, SrvPricalRateAndPriceDTO> temp = new HashMap<String, SrvPricalRateAndPriceDTO>();
					SrvPricalRateAndPriceDTO dto = new SrvPricalRateAndPriceDTO();
					dto.setId_srv(id_srv);
					dto.setError_msg("该服务为外挂的定价模式，暂时不支持查询外挂的定价模式！");
					temp.put(id_srv, dto);
					map.put(id_srv, temp);
				} else if (id_primd.equals(IBdPrimdCodeConst.ID_PRI_FREE)) // 不付费
				{
					Map<String, SrvPricalRateAndPriceDTO> temp = new HashMap<String, SrvPricalRateAndPriceDTO>();
					SrvPricalRateAndPriceDTO dto = new SrvPricalRateAndPriceDTO();
					dto.setId_srv(id_srv);
					dto.setError_msg("该服务不付费！");
					temp.put(id_srv, dto);
					map.put(id_srv, temp);
				} else if (id_primd.equals(IBdPrimdCodeConst.ID_PRI_SRVSET_AMOUNT)) // 服务套成员合计价
				{
					Map<String, Map<String, SrvPricalRateAndPriceDTO>> temp = CalSrvSetSumPriceByIdPripat_map(id_srv, id_pripat);
					map.putAll(temp);
				} else if (id_primd.equals(IBdPrimdCodeConst.ID_PRI_SRV_COMP)) // 组合计价
				{
					Map<String, SrvPricalRateAndPriceDTO> temp = CalSrvCompPriceByIdPripat_map(id_srv, id_pripat);
					map.put(id_srv, temp);
				} else if (id_primd.equals(IBdPrimdCodeConst.ID_PRI_SRVSET_MU)) // 服务套部位个数加收
				{
					// --1.查非临床项目
					// select * from bd_srvset_def where fg_clinical='N'
					PriStdSrvDTO[] priStdSrvDTO_noclinicial = getNoClinicalItmsFromBdSrvSetDef(id_srv);
					if (priStdSrvDTO_noclinicial != null && priStdSrvDTO_noclinicial.length > 0) {
						// Map<String,Map<String,Map<String,SrvPricalRateAndPriceDTO>>>
						// tempp=
						// calSrvPriUnderPripatsBatch(priStdSrvDTO_noclinicial);
						Map<String, Map<String, Map<String, SrvPricalRateAndPriceDTO>>> tempp = calSrvPriUnderPripatsBatch_srvAndComp(priStdSrvDTO_noclinicial, id_pripat);

						idpripat_map.putAll(tempp);
					}
					// --2.获得参与计算的数量
					// select count(*) from bd_srvset_def where fg_clinical='Y'
					// and fg_clinical_bl='Y'
					num = getNumFromBdSrvSetDef(id_srv);

					// 3. 1的收费+2的收费
					Map<String, Map<String, SrvPricalRateAndPriceDTO>> temp = CalSrvSetMUPricesByIdPripat_map(id_srv, num, id_pripat);
					map.putAll(temp);
				} else if (id_primd.equals(IBdPrimdCodeConst.ID_PRI_SRVSET_FIX)) // 服务套部位个数定价
				{
					// --1.查非临床项目
					// select * from bd_srvset_def where fg_clinical='N'
					PriStdSrvDTO[] priStdSrvDTO_noclinicial = getNoClinicalItmsFromBdSrvSetDef(id_srv);
					if (priStdSrvDTO_noclinicial != null && priStdSrvDTO_noclinicial.length > 0) {
						// Map<String,Map<String,Map<String,SrvPricalRateAndPriceDTO>>>
						// tempp=
						// calSrvPriUnderPripatsBatch(priStdSrvDTO_noclinicial);
						Map<String, Map<String, Map<String, SrvPricalRateAndPriceDTO>>> tempp = calSrvPriUnderPripatsBatch_srvAndComp(priStdSrvDTO_noclinicial, id_pripat);

						idpripat_map.putAll(tempp);
					}

					// --2.获得参与计算的数量
					// select count(*) from bd_srvset_def where fg_clinical='Y'
					// and fg_clinical_bl='Y'
					num = getNumFromBdSrvSetDef(id_srv);

					// 3. 1的收费+2的收费
					Map<String, Map<String, SrvPricalRateAndPriceDTO>> temp = CalSrvSetFIXPricesByIdPripat_map(id_srv, num, id_pripat);
					map.putAll(temp);
				} else {
					Map<String, SrvPricalRateAndPriceDTO> temp = new HashMap<String, SrvPricalRateAndPriceDTO>();
					SrvPricalRateAndPriceDTO dto = new SrvPricalRateAndPriceDTO();
					dto.setId_srv(id_srv);
					dto.setError_msg("该服务未在 定价模式 中定价。\r\n 服务ID: " + id_srv);
					temp.put(id_srv, dto);
					map.put(id_srv, temp);
				}
				if (map != null && map.size() > 0) {
					idpripat_map.put(priPatDO.getId_pripat(), map);
				}
			}
		}

		return idpripat_map;
	}

	/**
	 * 只计算定价模式为本服务定价或组织定价
	 * 
	 * @param pricalSrvDTO
	 *            <价格分类，<入参idsrv,<本服务定价ID_SRV或组合定价ID_SRV,价格信息>>>
	 * @return
	 * @throws BizException
	 */
	public Map<String, Map<String, Map<String, SrvPricalRateAndPriceDTO>>> calSrvPriUnderPripatsBatch_srvAndComp(PriStdSrvDTO[] pricalSrvDTOs, String id_pripat) throws BizException {
		Object result = null;
		FDouble price = new FDouble(0);
		SrvPriCalSql srvPriCalSql = new SrvPriCalSql();
		// List<PriStdSrvDTO> priStdSrvDTOLst=new ArrayList<PriStdSrvDTO>();
		PriStdSrvDTO[] priStdSrvDTOArr = null;
		String id_primd = "";
		String id_srv = "";
		String name = "";
		int num = 0;
		Map<String, Map<String, SrvPricalRateAndPriceDTO>> map = new HashMap<String, Map<String, SrvPricalRateAndPriceDTO>>();
		Map<String, Map<String, Map<String, SrvPricalRateAndPriceDTO>>> idpripat_map = new HashMap<String, Map<String, Map<String, SrvPricalRateAndPriceDTO>>>();
		List<MedSrvDO> medSrvDOLst = null;
		// 1.空校验
		if (pricalSrvDTOs == null || pricalSrvDTOs.length == 0) {
			Map<String, SrvPricalRateAndPriceDTO> temp = new HashMap<String, SrvPricalRateAndPriceDTO>();
			SrvPricalRateAndPriceDTO dto = new SrvPricalRateAndPriceDTO();
			dto.setId_srv("");
			dto.setError_msg("参数为空！");
			temp.put("", dto);
			map.put("", temp);
			idpripat_map.put("", map);
		}
		// 2.检索所有价格分类
		String[] fields = { "id_pripat" };
		String[] fields1 = { "id_primd", "id_srv", "name" };
		DAFacade dafacade = new DAFacade();
		List<PriPatDO> priPatDOLst = (List<PriPatDO>) dafacade.findByCond(PriPatDO.class, " 1=1", fields);
		if (priPatDOLst == null || priPatDOLst.size() == 0) {
			Map<String, SrvPricalRateAndPriceDTO> temp = new HashMap<String, SrvPricalRateAndPriceDTO>();
			SrvPricalRateAndPriceDTO dto = new SrvPricalRateAndPriceDTO();
			dto.setId_srv("");
			dto.setError_msg("价格分类为空！");
			temp.put("", dto);
			map.put("", temp);
			idpripat_map.put("", map);
		}
		// 3.循环计算每个价格分类下的服务折扣价

		for (PriStdSrvDTO priStdSrvDTO : pricalSrvDTOs) {
			map = new HashMap<String, Map<String, SrvPricalRateAndPriceDTO>>();
			// 3.1获取服务对应的定价模式
			id_srv = priStdSrvDTO.getId_srv();
			medSrvDOLst = (List<MedSrvDO>) dafacade.findByCond(MedSrvDO.class, " id_srv='" + priStdSrvDTO.getId_srv() + "'", fields1);
			if (medSrvDOLst == null || medSrvDOLst.size() == 0) {
				Map<String, SrvPricalRateAndPriceDTO> temp = new HashMap<String, SrvPricalRateAndPriceDTO>();
				SrvPricalRateAndPriceDTO dto = new SrvPricalRateAndPriceDTO();
				dto.setId_srv(id_srv);
				dto.setError_msg("定价模式为空！");
				temp.put(id_srv, dto);
				map.put(id_srv, temp);
			}
			id_primd = medSrvDOLst.toArray(new MedSrvDO[0])[0].getId_primd();
			name = medSrvDOLst.toArray(new MedSrvDO[0])[0].getName();
			if (id_primd.equals(IBdPrimdCodeConst.ID_PRI_SRV)) // 本服务定价
			{
				SrvPricalRateAndPriceDTO srvPricalRateAndPriceDTO = CalSingleSrvPriceByIdPripat_NameTip_withoutThrow(id_srv, name, id_pripat);
				Map<String, SrvPricalRateAndPriceDTO> temp = new HashMap<String, SrvPricalRateAndPriceDTO>();
				temp.put(priStdSrvDTO.getId_srv(), srvPricalRateAndPriceDTO);
				map.put(id_srv, temp);
			} else if (id_primd.equals(IBdPrimdCodeConst.ID_PRI_PLUGIN)) // 外挂的定价模式
			{
				// 采用外挂的定价模式

				// 目前为了程序不报错而写
				Map<String, SrvPricalRateAndPriceDTO> temp = new HashMap<String, SrvPricalRateAndPriceDTO>();
				SrvPricalRateAndPriceDTO dto = new SrvPricalRateAndPriceDTO();
				dto.setId_srv(id_srv);
				dto.setError_msg("该服务为外挂的定价模式，暂时不支持查询外挂的定价模式！");
				temp.put(id_srv, dto);
				map.put(id_srv, temp);
			} else if (id_primd.equals(IBdPrimdCodeConst.ID_PRI_FREE)) // 不付费
			{
				Map<String, SrvPricalRateAndPriceDTO> temp = new HashMap<String, SrvPricalRateAndPriceDTO>();
				SrvPricalRateAndPriceDTO dto = new SrvPricalRateAndPriceDTO();
				dto.setId_srv(id_srv);
				dto.setError_msg("该服务不付费！");
				temp.put(id_srv, dto);
				map.put(id_srv, temp);
			} else if (id_primd.equals(IBdPrimdCodeConst.ID_PRI_SRV_COMP)) // 组合计价
			{
				Map<String, SrvPricalRateAndPriceDTO> temp = CalSrvCompPriceByIdPripat_map(id_srv, id_pripat);
				map.put(id_srv, temp);
			} else {
				Map<String, SrvPricalRateAndPriceDTO> temp = new HashMap<String, SrvPricalRateAndPriceDTO>();
				SrvPricalRateAndPriceDTO dto = new SrvPricalRateAndPriceDTO();
				dto.setId_srv(id_srv);
				dto.setError_msg("该服务未在 定价模式 中定价。\r\n 服务ID: " + id_srv);
				temp.put(id_srv, dto);
				map.put(id_srv, temp);
			}
			if (map != null && map.size() > 0) {
				idpripat_map.put(id_pripat, map);
			}
		}

		return idpripat_map;
	}

	/**
	 * 获得服务套中的非临床项目
	 * 
	 * @param id_srv_set
	 *            服务套ID
	 * @return 非临床项目
	 * @throws BizException
	 */
	private PriStdSrvDTO[] getNoClinicalItmsFromBdSrvSetDef(String id_srv_set) throws BizException {
		List<PriStdSrvDTO> priStdSrvDTOLst = new ArrayList<PriStdSrvDTO>();
		DAFacade dafacade = new DAFacade();
		StringBuffer sqlb = new StringBuffer();
		sqlb.append(" select b.id_srv,b.name from bd_srvset_def a inner join bd_srv b on a.id_srv_itm=b.id_srv where a.fg_clinical='N' and a.id_srv=? ");
		SqlParam sqlp = new SqlParam();
		sqlp.addParam(id_srv_set);
		List<MedSrvDO> medSrvDOLst = (List<MedSrvDO>) dafacade.execQuery(sqlb.toString(), sqlp, new BeanListHandler(MedSrvDO.class));
		for (MedSrvDO medSrvDO : medSrvDOLst) {
			PriStdSrvDTO priStdSrvDTO1 = new PriStdSrvDTO();
			priStdSrvDTO1.setId_srv(medSrvDO.getId_srv());
			priStdSrvDTO1.setName_srv(medSrvDO.getName());
			priStdSrvDTOLst.add(priStdSrvDTO1);
		}
		if (priStdSrvDTOLst != null && priStdSrvDTOLst.size() > 0) {
			return priStdSrvDTOLst.toArray(new PriStdSrvDTO[0]);
		} else {
			return null;
		}
	}

	/**
	 * 获得服务套中需要参与计算的数量
	 * 
	 * @param id_srv_set
	 *            服务套ID
	 * @return 数量
	 * @throws BizException
	 */
	private int getNumFromBdSrvSetDef(String id_srv_set) throws BizException {
		// int num=0;
		// DAFacade dafacade=new DAFacade();
		// StringBuffer sqlb1 = new StringBuffer();
		// sqlb1.append(" select count(*) from bd_srvset_def where fg_clinical='Y' and fg_clinical_bl='Y' and id_srv='"+id_srv_set+"' ");
		// List<String> list= (List<String>) new
		// DAFacade().execQuery(sqlb1.toString(), new ColumnListHandler());
		// if(list!=null && list.size()>0)
		// {
		// num=Integer.parseInt(list.toArray(new String[0])[0]);
		// }
		MedSrvSetItemDO[] setItems = ServiceFinder.find(IMedSrvSetItemDORService.class).find(String.format("a8.fg_clinical='Y' and a8.fg_clinical_bl='Y' and a8.id_srv='%s'", id_srv_set), "", FBoolean.FALSE);

		return setItems == null ? 0 : setItems.length;
	}

	/**
	 * 根据患者价格分类和服务数组（id_srv,id_name),返回服务相关信息（标准价格，价格比例，服务分类，服务分类或项目）
	 * 
	 * @param pricalSrvDTO
	 *            待计价服务数组（id_srv,id_name)
	 * @param id_pripat
	 *            患者价格分类
	 * @return 服务相关信息（标准价格，价格比例，服务分类，服务分类或项目）
	 * @throws BizException
	 */
	public SrvPricalRateAndPriceDTO[] CalManySrvsPriceMapByIdPripat(PriStdSrvDTO[] pricalSrvDTO, String id_pripat) throws BizException {
		if (pricalSrvDTO == null) {
			throw new BizException("未指定服务。");
		}
		if (("").equals(id_pripat)) {
			throw new BizException("未指定价格分类ID。");
		}
		Map<String, FDouble> srvPriceMap = new HashMap<String, FDouble>();
		List<SrvPricalRateAndPriceDTO> srvPricalRateAndPriceDTOList = new ArrayList<SrvPricalRateAndPriceDTO>();
		if (pricalSrvDTO.length < 100) {
			for (int i = 0; i < pricalSrvDTO.length; i++) {
				// srvPriceMap.put(pricalSrvDTO[i].getId_srv(),
				// CalSingleSrvStdPrice_NameTip(pricalSrvDTO[i].getId_srv(),pricalSrvDTO[i].getName_srv()));
				SrvPricalRateAndPriceDTO srvPricalRateAndPriceDTO = new SrvPricalRateAndPriceDTO();
				srvPricalRateAndPriceDTO = CalSingleSrvPriceByIdPripat_NameTip(pricalSrvDTO[i].getId_srv(), pricalSrvDTO[i].getName_srv(), id_pripat);
				srvPricalRateAndPriceDTOList.add(srvPricalRateAndPriceDTO);
			}
		} else {
			SrvPricalRateAndPriceDTO[] srvPricalDTO_Arr = GetAllSrvRatelByIdPripat(id_pripat);
			// 查询价格分类
			IPripatMDORService iPripatMDORService = ServiceFinder.find(IPripatMDORService.class);
			PriPatDO priPatDO = iPripatMDORService.findById(id_pripat);
			for (int i = 0; i < pricalSrvDTO.length; i++) {
				SrvPricalRateAndPriceDTO srvPricalRateAndPriceDTO = new SrvPricalRateAndPriceDTO();
				srvPricalRateAndPriceDTO = CalSingleSrvPriceByIdPripatx_New_NameTip(pricalSrvDTO[i].getId_srv(), pricalSrvDTO[i].getName_srv(), priPatDO, srvPricalDTO_Arr);
				srvPricalRateAndPriceDTOList.add(srvPricalRateAndPriceDTO);

			}
		}
		return srvPricalRateAndPriceDTOList.toArray(new SrvPricalRateAndPriceDTO[] {});
	}

	/**
	 * 供CI折扣价调用（本服务定价模式批量接口）
	 * 根据患者价格分类和服务数组（id_srv,Name_srv),返回服务相关信息（服务项目，价格系数，标准价格，折扣价格，数量，错误信息）
	 * 
	 * @param pricalSrvDTO
	 *            待计价服务数组（id_srv,Name_srv)
	 * @param id_pripat
	 *            患者价格分类
	 * @return 服务相关信息（服务项目，价格系数，标准价格，折扣价格，数量，错误信息）
	 * @throws BizException
	 */
	public SrvPricalRateAndPriceDTO[] CalManySrvsPriceMapByIdPripat_withoutThrow(PriStdSrvDTO[] pricalSrvDTO, String id_pripat) throws BizException {
		List<SrvPricalRateAndPriceDTO> srvPricalRateAndPriceDTOList = new ArrayList<SrvPricalRateAndPriceDTO>();
		if (pricalSrvDTO == null) {
			SrvPricalRateAndPriceDTO srvPricalRateAndPriceDTO = new SrvPricalRateAndPriceDTO();
			srvPricalRateAndPriceDTO.setId_srv("");
			srvPricalRateAndPriceDTO.setError_msg("未指定服务。");
			srvPricalRateAndPriceDTOList.add(srvPricalRateAndPriceDTO);
			// throw new BizException("未指定服务。");
		}
		if (("").equals(id_pripat)) {
			// throw new BizException("未指定价格分类ID。");
			SrvPricalRateAndPriceDTO srvPricalRateAndPriceDTO = new SrvPricalRateAndPriceDTO();
			srvPricalRateAndPriceDTO.setId_srv("");
			srvPricalRateAndPriceDTO.setError_msg("未指定价格分类ID。");
			srvPricalRateAndPriceDTOList.add(srvPricalRateAndPriceDTO);
		}
		// Map<String,FDouble> srvPriceMap=new HashMap<String,FDouble>();

		if (pricalSrvDTO.length < 100) {
			for (int i = 0; i < pricalSrvDTO.length; i++) {
				// srvPriceMap.put(pricalSrvDTO[i].getId_srv(),
				// CalSingleSrvStdPrice_NameTip(pricalSrvDTO[i].getId_srv(),pricalSrvDTO[i].getName_srv()));
				SrvPricalRateAndPriceDTO srvPricalRateAndPriceDTO = new SrvPricalRateAndPriceDTO();
				srvPricalRateAndPriceDTO = CalSingleSrvPriceByIdPripat_NameTip_withoutThrow(pricalSrvDTO[i].getId_srv(), pricalSrvDTO[i].getName_srv(), id_pripat);
				srvPricalRateAndPriceDTOList.add(srvPricalRateAndPriceDTO);
			}
		} else {
			SrvPricalRateAndPriceDTO[] srvPricalDTO_Arr = GetAllSrvRatelByIdPripat(id_pripat);
			// 查询价格分类
			IPripatMDORService iPripatMDORService = ServiceFinder.find(IPripatMDORService.class);
			PriPatDO priPatDO = iPripatMDORService.findById(id_pripat);
			for (int i = 0; i < pricalSrvDTO.length; i++) {
				SrvPricalRateAndPriceDTO srvPricalRateAndPriceDTO = new SrvPricalRateAndPriceDTO();
				srvPricalRateAndPriceDTO = CalSingleSrvPriceByIdPripatx_New_NameTip_withoutThrow(pricalSrvDTO[i].getId_srv(), pricalSrvDTO[i].getName_srv(), priPatDO, srvPricalDTO_Arr);
				srvPricalRateAndPriceDTOList.add(srvPricalRateAndPriceDTO);

			}
		}
		return srvPricalRateAndPriceDTOList.toArray(new SrvPricalRateAndPriceDTO[] {});
	}

	/**
	 * 更加患者价格分类和服务数组（id_srv,id_name),返回服务相关信息<id_srv,（标准价格，价格比例，服务分类，服务分类或项目，
	 * 错误信息）>
	 * 
	 * @param pricalSrvDTO
	 *            待计价服务数组（id_srv,id_name)
	 * @param id_pripat
	 *            患者价格分类
	 * @return 返回map格式的，服务相关信息<id_srv,（标准价格，价格比例，服务分类，服务分类或项目，错误信息）>
	 * @throws BizException
	 */
	public Map<String, SrvPricalRateAndPriceDTO> CalManySrvsPriceMapByIdPripat_map(PriStdSrvDTO[] pricalSrvDTO, String id_pripat) throws BizException {
		Map<String, SrvPricalRateAndPriceDTO> map = new HashMap<String, SrvPricalRateAndPriceDTO>();
		if (pricalSrvDTO == null) {
			SrvPricalRateAndPriceDTO dto1 = new SrvPricalRateAndPriceDTO();
			dto1.setError_msg("未指定服务。");
			map.put("", dto1);

		}
		if (("").equals(id_pripat)) {
			SrvPricalRateAndPriceDTO dto2 = new SrvPricalRateAndPriceDTO();
			dto2.setError_msg("未指定价格分类ID。");
			map.put("", dto2);

		}
		Map<String, FDouble> srvPriceMap = new HashMap<String, FDouble>();
		List<SrvPricalRateAndPriceDTO> srvPricalRateAndPriceDTOList = new ArrayList<SrvPricalRateAndPriceDTO>();
		if (pricalSrvDTO.length < 100) {
			for (int i = 0; i < pricalSrvDTO.length; i++) {
				// srvPriceMap.put(pricalSrvDTO[i].getId_srv(),
				// CalSingleSrvStdPrice_NameTip(pricalSrvDTO[i].getId_srv(),pricalSrvDTO[i].getName_srv()));
				SrvPricalRateAndPriceDTO srvPricalRateAndPriceDTO = new SrvPricalRateAndPriceDTO();
				srvPricalRateAndPriceDTO = CalSingleSrvPriceByIdPripat_NameTip_withoutThrow(pricalSrvDTO[i].getId_srv(), pricalSrvDTO[i].getName_srv(), id_pripat);
				// srvPricalRateAndPriceDTOList.add(srvPricalRateAndPriceDTO);
				map.put(pricalSrvDTO[i].getId_srv(), srvPricalRateAndPriceDTO);

			}
		} else {
			SrvPricalRateAndPriceDTO[] srvPricalDTO_Arr = GetAllSrvRatelByIdPripat(id_pripat);
			// 查询价格分类
			IPripatMDORService iPripatMDORService = ServiceFinder.find(IPripatMDORService.class);
			PriPatDO priPatDO = iPripatMDORService.findById(id_pripat);
			for (int i = 0; i < pricalSrvDTO.length; i++) {
				SrvPricalRateAndPriceDTO srvPricalRateAndPriceDTO = new SrvPricalRateAndPriceDTO();
				srvPricalRateAndPriceDTO = CalSingleSrvPriceByIdPripatx_New_NameTip_withoutThrow(pricalSrvDTO[i].getId_srv(), pricalSrvDTO[i].getName_srv(), priPatDO, srvPricalDTO_Arr);
				// srvPricalRateAndPriceDTOList.add(srvPricalRateAndPriceDTO);
				map.put(pricalSrvDTO[i].getId_srv(), srvPricalRateAndPriceDTO);

			}
		}
		return map;
	}

	/**
	 * 更加患者ID_ENT和服务数组（id_srv,id_name),返回服务相关信息（标准价格，价格比例，服务分类，服务分类或项目）
	 * 
	 * @param pricalSrvDTO
	 *            待计价服务数组（id_srv,id_name)
	 * @param id_ent
	 *            患者ID_ENT
	 * @return 服务相关信息（标准价格，价格比例，服务分类，服务分类或项目）
	 * @throws BizException
	 */
	public SrvPricalRateAndPriceDTO[] CalManySrvsPriceMapByIdent(PriStdSrvDTO[] pricalSrvDTO, String id_ent) throws BizException {
		// 通过id_ent找到id_pripat
		// PatiVisitDO
		String[] fields = { "id_ent", "id_pripat" };
		DAFacade dafacade = new DAFacade();
		List<PatiVisitDO> patiVisitDOLst = (List<PatiVisitDO>) dafacade.findByCond(PatiVisitDO.class, " id_ent='" + id_ent + "'", fields);
		if (patiVisitDOLst == null || patiVisitDOLst.size() == 0) {
			throw new BizException("未找到患者就诊对应的价格分类ID");
		}
		String id_pripat = patiVisitDOLst.toArray(new PatiVisitDO[0])[0].getId_pripat();

		return CalManySrvsPriceMapByIdPripat(pricalSrvDTO, id_pripat);
	}

	/**
	 * 循环调用计算单个服务标准价格完成多服务标准计价
	 * 
	 * @param pricalSrvDTO
	 *            需要计算价格的服务数组
	 * @return 返回价格
	 */
	public Map<String, FDouble> CalManySrvStdPriceMap(PriStdSrvDTO[] pricalSrvDTO) throws BizException {

		Map<String, FDouble> srvPriceMap = new HashMap<String, FDouble>();

		for (int i = 0; i < pricalSrvDTO.length; i++) {
			srvPriceMap.put(pricalSrvDTO[i].getId_srv(), CalSingleSrvStdPrice_NameTip(pricalSrvDTO[i].getId_srv(), pricalSrvDTO[i].getName_srv()));
		}

		return srvPriceMap;

	}

	// /**
	// * 计算多个服务价格
	// * @param id_patpritp 患者价格分类
	// * @param srvs 需计算价格的服务ID数组
	// * @return 包含实际价格的服务ID数组
	// */
	// public PricalSrvDTO[] CalSrvsPrice(String id_patpritp ,PricalSrvDTO[]
	// srvs){
	//
	//
	// return srvs;
	// }
	/**
	 * 查询服务的当前价格，返回Map<服务ID，服务价格>
	 * 
	 * @return
	 * @throws DAException
	 */
	private Map<String, FDouble> CalAllSrvsStdPrice() throws BizException {
		SrvPriCalSql srvPriCalSql = new SrvPriCalSql();
		TimeService timeService = new TimeServiceImpl();
		String strDateTime = timeService.getUFDateTime().toStdString();
		Map<String, FDouble> srvPriceMap = new HashMap<String, FDouble>();
		String sql = srvPriCalSql.GetAllSrvPriceSql();
		SqlParam sqlParam = new SqlParam();
		// sqlParam.addParam(strDateTime);
		// sqlParam.addParam(strDateTime);
		List<PriStdSrvDTO> list = (List<PriStdSrvDTO>) new DAFacade().execQuery(sql, sqlParam, new BeanListHandler(PriStdSrvDTO.class));
		for (PriStdSrvDTO srv : list) {
			srvPriceMap.put(srv.getId_srv(), srv.getPrice());
		}
		return srvPriceMap;
	}

	// /**
	// * 按患者价格分类，在已获得服务标准价格基础上，计算服务实收价格
	// * @param srvs 已经包含标准价格的服务
	// * @param id_patpritp 患者价格分类
	// * @return 按患者价格分类，在已获得服务标准价格基础上，计算服务实收价格
	// * @throws DAException
	// */
	// public PricalSrvDTO[] CalSrvsPrice(PricalSrvDTO[] srvs,String
	// id_patpritp) throws BizException
	// {
	// PricalSrvDTO[] pricalSrv=null;
	// if(id_patpritp != null && !id_patpritp.equals(""))
	// {
	// //先计算标准价格
	// pricalSrv=CalSrvsStdPrice(srvs);
	// }
	// else
	// {
	// pricalSrv=srvs;
	// }
	// //计算服务实收:未完成
	//
	// return pricalSrv;
	// }
	// /**
	// * 计算多个服务标准价格
	// * @param srvs 需计算价格的服务ID数组
	// * @return 包含标准价格的服务ID数组
	// */
	// public PricalSrvDTO[] CalSrvsStdPrice(PricalSrvDTO[] srvs) throws
	// BizException
	// {
	// //检索当前价表
	// Map<String,FDouble> srvPriceMap=new HashMap<String,FDouble>();
	// srvPriceMap=CalAllSrvsStdPrice();
	//
	//
	// for(int i=0;i<srvs.length;i++)
	// {
	// if(srvPriceMap.get(srvs[i].getId_srv())==null)
	// {
	// break;
	// }
	// switch(srvs[i].getId_primd())
	// {
	// case PrimdType.PRISRV://本服务定价
	// srvs[i].setAmtStd(srvPriceMap.get(srvs[i].getId_srv()).multiply(srvs[i].getAmount()));
	// break;
	// case PrimdType.PRISRVSETAMOUNT:// 服务套成员合计价
	//
	// break;
	// case PrimdType.PRISRVSETMU:// 服务套成员项目部位个数加收
	//
	// break;
	// case PrimdType.PRISRVSETFIX:// 服务套成员项目个数定价
	//
	// break;
	// case PrimdType.PRIRES:// 服务套成员合计价
	//
	// break;
	// case PrimdType.PRISRVPACK:// 服务包总价模式
	//
	// break;
	// case PrimdType.PRIPLUGIN:// 外挂价格定价插件
	//
	// break;
	// default:
	// break;
	// }
	// }
	// return srvs;
	// }

	/**
	 * 根据多个服务ID，计算多个服务标准价格
	 */
	@Override
	public PriStdSrvDTO[] CalManySrvsStdPrices(PriStdSrvDTO[] pricalSrvDTOArr) throws BizException {
		for (PriStdSrvDTO pricalSrvDTO : pricalSrvDTOArr) {
			pricalSrvDTO.setPrice(CalSingleSrvStdPrice_NameTip(pricalSrvDTO.getId_srv(), pricalSrvDTO.getName_srv()));
		}
		return pricalSrvDTOArr;
		// //获得所有当前服务价格
		// Map<String,FDouble> srvPriceMap=new HashMap<String,FDouble>();
		// if(pricalSrvDTO.length>100) //考虑到性能问题
		// {
		// srvPriceMap=CalAllSrvsStdPrice(); //查询所有服务
		// }
		// else
		// {
		// srvPriceMap=CalManySrvStdPriceMap(pricalSrvDTO);
		// }
		// for(int i=0;i<pricalSrvDTO.length;i++)
		// {
		// if(srvPriceMap.get(pricalSrvDTO[i].getId_srv())==null)
		// {
		// throw new
		// BizException("服务: "+pricalSrvDTO[i].getName_srv()+" 不存在或不存在当前价格");
		// }
		// pricalSrvDTO[i].setPrice(srvPriceMap.get(pricalSrvDTO[i].getId_srv()));
		// }
		// return pricalSrvDTO;
	}

	// /**
	// * 计算服务套成员项目部位个数加收（加收对应的加收服务ID，标准价格）
	// */
	// @Override
	// public PriStdSrvDTO CalSrvSetMUPrice(String Id_srv_set, int num)
	// throws BizException {
	// PriStdSrvDTO priStdSrvDTO=null;
	// if(Id_srv_set.indexOf(";")>0)
	// {
	// throw new BizException("服务套含非法字符");
	// }
	// String cond=" a0.id_srvset = '"+Id_srv_set+"'";
	// Object obj4 = ServiceFinder.find(IPrisrvsetmuRService.class);
	// PriSrvSetMuDO[] priSrvSetMuDOs=((IPrisrvsetmuRService)obj4).find(cond,
	// "quan_min asc", FBoolean.FALSE);
	// if(null==priSrvSetMuDOs)
	// {
	// throw new BizException("查询服务套部位数量加收模式信息失败");
	// }
	// String Id_srv="",Name_srv="";
	// for(int i=0;i<priSrvSetMuDOs.length;i++)
	// {
	// if(priSrvSetMuDOs[i].getQuan_min().compareTo(new FDouble(num))<=0)
	// {
	// if(priSrvSetMuDOs[i].getQuan_max()==null ||
	// (priSrvSetMuDOs[i].getQuan_max()!=null &&
	// priSrvSetMuDOs[i].getQuan_max().compareTo(new FDouble(num))>=0))
	// {
	// Id_srv=priSrvSetMuDOs[i].getId_srvadd();
	// priStdSrvDTO=new PriStdSrvDTO();
	// Name_srv=priSrvSetMuDOs[i].getSrv_name();
	// priStdSrvDTO.setId_srv(Id_srv);
	// priStdSrvDTO.setName_srv(priSrvSetMuDOs[i].getSrv_name());
	// priStdSrvDTO.setPrice(CalSingleSrvStdPrice_NameTip(Id_srv,Name_srv));
	// break;
	// }
	// }
	// }
	//
	// return priStdSrvDTO;
	// }
	// /**
	// * 计算服务套成员项目个数定价（加收对应的加收服务ID，标准价格）
	// */
	// @Override
	// public PriStdSrvDTO CalSrvSetFIXPrice(String Id_srv_set, int num)
	// throws BizException {
	// PriStdSrvDTO priStdSrvDTO=null;
	// if(Id_srv_set.indexOf(";")>0)
	// {
	// throw new BizException("服务套含非法字符");
	// }
	// String cond=" a0.id_srvset = '"+Id_srv_set+"'";
	// Object obj4 = ServiceFinder.find(IPrisrvsetfixRService.class);
	// PriSrvSetFixDO[] priSrvSetMuDOs=((IPrisrvsetfixRService)obj4).find(cond,
	// "quan_min asc", FBoolean.FALSE);
	// if(null==priSrvSetMuDOs)
	// {
	// throw new BizException("查询服务套数量定价模式信息失败");
	// }
	// String Id_srv="";
	// for(int i=0;i<priSrvSetMuDOs.length;i++)
	// {
	// if(priSrvSetMuDOs[i].getQuan_min().compareTo(new FDouble(num))<=0 )
	// {
	// if(priSrvSetMuDOs[i].getQuan_max()==null ||
	// (priSrvSetMuDOs[i].getQuan_max()!=null &&
	// priSrvSetMuDOs[i].getQuan_max().compareTo(new FDouble(num))>=0 ))
	// {
	// priStdSrvDTO=new PriStdSrvDTO();
	// Id_srv=priSrvSetMuDOs[i].getId_srvadd();
	// priStdSrvDTO.setId_srv(Id_srv);
	// priStdSrvDTO.setName_srv(priSrvSetMuDOs[i].getSrv_name());
	// priStdSrvDTO.setPrice(CalSingleSrvStdPrice_NameTip(Id_srv,priSrvSetMuDOs[i].getSrv_name()));
	// break;
	// }
	// }
	// }
	//
	// return priStdSrvDTO;
	// }
	//
	/**
	 * 获得服务套内项目价格
	 * 
	 * @param id_srv_set
	 *            服务ID
	 * @return SrvSetItemDTO[]
	 * @throws BizException
	 */
	public SrvSetItemDTO[] getSrvSetItemDTO_price(String id_srv) throws BizException {
		// 1. 获得服务定义
		IBdSrvQryService iBdSrvQryService = ServiceFinder.find(IBdSrvQryService.class);
		SrvSetItemDTO[] srvSetItemDTOArr = iBdSrvQryService.getSrvSetSrvItemsInfo(id_srv);
		DAFacade dafacade = new DAFacade();
		String id_primd = "", name_srv = "", id_srv1 = "";
		FDouble price = new FDouble(0);
		// 2.获得服务对于的价格
		for (SrvSetItemDTO srvSetItemDTO : srvSetItemDTOArr) {
			// 2.1 检查定价模式，是组合定价还是本服务定价
			List<MedSrvDO> medSrvDO1 = (List<MedSrvDO>) dafacade.findByCond(MedSrvDO.class, " id_srv='" + srvSetItemDTO.getId_srv() + "' ", new String[] { "id_primd" });
			if (medSrvDO1 != null && medSrvDO1.size() > 0) {
				id_primd = medSrvDO1.toArray(new MedSrvDO[0])[0].getId_primd();
			} else {
				continue;
			}
			name_srv = srvSetItemDTO.getName();
			id_srv1 = srvSetItemDTO.getId_srv();
			if (IBdPrimdCodeConst.ID_PRI_SRV.equals(id_primd)) // 2.2本服务定价
			{
				PriStdSrvDTO priStdSrvDTO = new PriStdSrvDTO();
				price = CalSingleSrvStdPrice_NameTip(id_srv1, name_srv);
				srvSetItemDTO.setPrice(price);
			} else if (IBdPrimdCodeConst.ID_PRI_SRV_COMP.equals(id_primd))// 2.2组合定价
			{
				price = new FDouble(0);
				PriStdSrvDTO[] tempDtos = this.CalSrvCompPrice(id_srv1);
				for (PriStdSrvDTO priStdSrvDTO : tempDtos) {
					price = price.add(priStdSrvDTO.getQuan().multiply(priStdSrvDTO.getPrice()));
				}
				srvSetItemDTO.setPrice(price);
			} else if (IBdPrimdCodeConst.CODE_PRI_RES.equals(id_primd))// 2.2物品定价,定义阶段无法确定id_mm，因此无价
			{
				srvSetItemDTO.setPrice(null);// 绑定是定价
			}
		}
		return srvSetItemDTOArr;
	}

	/**
	 * 计算服务套成员项目部位个数加收（加收对应的加收服务ID，标准价格）
	 */
	@Override
	public PriStdSrvDTO[] CalSrvSetMUPrices(String Id_srv_set, int num) throws BizException {

		List<PriStdSrvDTO> priStdSrvDTOLst = new ArrayList<PriStdSrvDTO>();
		DAFacade dafacade = new DAFacade();
		if (Id_srv_set.indexOf(";") > 0) {
			throw new BizException("服务套含非法字符");
		}
		String cond = " a0.id_srvset = '" + Id_srv_set + "' and a0.ds='0'";
		Object obj4 = ServiceFinder.find(IPrisrvsetmuRService.class);
		PriSrvSetMuDO[] priSrvSetMuDOs = ((IPrisrvsetmuRService) obj4).find(cond, "quan_min asc", FBoolean.FALSE);
		if (null == priSrvSetMuDOs) {
			throw new BizException("查询服务套部位数量加收模式信息失败");
		}
		String Id_srv = "", Name_srv = "", id_primd = "";
		for (int i = 0; i < priSrvSetMuDOs.length; i++) {
			if (priSrvSetMuDOs[i].getQuan_min().compareTo(new FDouble(num)) <= 0) {
				if (priSrvSetMuDOs[i].getQuan_max() == null || (priSrvSetMuDOs[i].getQuan_max() != null && priSrvSetMuDOs[i].getQuan_max().compareTo(new FDouble(num)) >= 0)) {
					Id_srv = priSrvSetMuDOs[i].getId_srvadd();
					// 检查定价模式，是组合定价还是本服务定价
					List<MedSrvDO> medSrvDO1 = (List<MedSrvDO>) dafacade.findByCond(MedSrvDO.class, " id_srv='" + Id_srv + "' ", new String[] { "id_primd" });
					if (medSrvDO1 != null && medSrvDO1.size() > 0) {
						id_primd = medSrvDO1.toArray(new MedSrvDO[0])[0].getId_primd();
					}
					if (IBdPrimdCodeConst.ID_PRI_SRV.equals(id_primd)) // 本服务定价
					{
						PriStdSrvDTO priStdSrvDTO = new PriStdSrvDTO();
						Name_srv = priSrvSetMuDOs[i].getSrv_name();
						priStdSrvDTO.setId_srv(Id_srv);
						priStdSrvDTO.setName_srv(priSrvSetMuDOs[i].getSrv_name());
						priStdSrvDTO.setPrice(CalSingleSrvStdPrice_NameTip(Id_srv, Name_srv));
						priStdSrvDTOLst.add(priStdSrvDTO);
					} else if (IBdPrimdCodeConst.ID_PRI_SRV_COMP.equals(id_primd))// 组合定价
					{
						PriStdSrvDTO[] tempDtos = this.CalSrvCompPrice(Id_srv);
						for (PriStdSrvDTO priStdSrvDTO : tempDtos) {
							priStdSrvDTOLst.add(priStdSrvDTO);
						}
					}
					break;
				}
			}
		}

		return priStdSrvDTOLst.toArray(new PriStdSrvDTO[0]);
	}

	// /**
	// * 计算服务套成员项目部位个数加收（加收对应的加收服务ID，标准价格）
	// */
	/**
	 * 供CI折扣价调用(服务套成员项目部位加收定价模式接口) 计算服务套成员项目部位个数加收（加收对应的加收服务ID，标准价格）
	 * 
	 * @param Id_srv_set
	 *            服务套
	 * @param num
	 *            部位个数加收
	 * @param id_pripat
	 *            价格分类
	 * @return 返回Map<String,Map<String,SrvPricalRateAndPriceDTO>>格式的服务相关信息
	 *         <本服务ID或者组合定价ID,<id_srv,（服务项目，价格系数，标准价格，折扣价格，数量，错误信息）>定价内容>
	 * @throws BizException
	 */
	public Map<String, Map<String, SrvPricalRateAndPriceDTO>> CalSrvSetMUPricesByIdPripat_map(String Id_srv_set, int num, String id_pripat) throws BizException {

		Map<String, Map<String, SrvPricalRateAndPriceDTO>> map = new HashMap<String, Map<String, SrvPricalRateAndPriceDTO>>();
		// List<PriStdSrvDTO> priStdSrvDTOLst=new ArrayList<PriStdSrvDTO>();
		DAFacade dafacade = new DAFacade();
		if (Id_srv_set.indexOf(";") > 0) {
			// throw new BizException("服务套含非法字符");
			SrvPricalRateAndPriceDTO dto1 = new SrvPricalRateAndPriceDTO();
			Map<String, SrvPricalRateAndPriceDTO> tmap = new HashMap<String, SrvPricalRateAndPriceDTO>();
			dto1.setError_msg("服务套含非法字符。");
			tmap.put("", dto1);
			map.put("", tmap);
		}
		String cond = " a0.id_srvset = '" + Id_srv_set + "' and a0.ds='0'";
		Object obj4 = ServiceFinder.find(IPrisrvsetmuRService.class);
		PriSrvSetMuDO[] priSrvSetMuDOs = ((IPrisrvsetmuRService) obj4).find(cond, "quan_min asc", FBoolean.FALSE);
		if (null == priSrvSetMuDOs) {
			SrvPricalRateAndPriceDTO dto2 = new SrvPricalRateAndPriceDTO();
			Map<String, SrvPricalRateAndPriceDTO> tmap = new HashMap<String, SrvPricalRateAndPriceDTO>();
			dto2.setError_msg("查询服务套部位数量加收模式信息失败。");
			tmap.put("", dto2);
			map.put("", tmap);
		}
		String Id_srv = "", Name_srv = "", id_primd = "";
		for (int i = 0; i < priSrvSetMuDOs.length; i++) {
			if (priSrvSetMuDOs[i].getQuan_min().compareTo(new FDouble(num)) <= 0) {
				if (priSrvSetMuDOs[i].getQuan_max() == null || (priSrvSetMuDOs[i].getQuan_max() != null && priSrvSetMuDOs[i].getQuan_max().compareTo(new FDouble(num)) >= 0)) {
					Id_srv = priSrvSetMuDOs[i].getId_srvadd();
					// 检查定价模式，是组合定价还是本服务定价
					List<MedSrvDO> medSrvDO1 = (List<MedSrvDO>) dafacade.findByCond(MedSrvDO.class, " id_srv='" + Id_srv + "' ", new String[] { "id_primd" });
					if (medSrvDO1 != null && medSrvDO1.size() > 0) {
						id_primd = medSrvDO1.toArray(new MedSrvDO[0])[0].getId_primd();
					}
					if (IBdPrimdCodeConst.ID_PRI_SRV.equals(id_primd)) // 本服务定价
					{
						PriStdSrvDTO priStdSrvDTO = new PriStdSrvDTO();
						Name_srv = priSrvSetMuDOs[i].getSrv_name();
						SrvPricalRateAndPriceDTO srvPricalRateAndPriceDTO = CalSingleSrvPriceByIdPripat_NameTip_withoutThrow(Id_srv, Name_srv, id_pripat);
						Map<String, SrvPricalRateAndPriceDTO> map_temp = new HashMap<String, SrvPricalRateAndPriceDTO>();
						map_temp.put(Id_srv, srvPricalRateAndPriceDTO);
						map.put(Id_srv_set, map_temp);
					} else if (IBdPrimdCodeConst.ID_PRI_SRV_COMP.equals(id_primd))// 组合定价
					{
						Map<String, SrvPricalRateAndPriceDTO> map_comp = this.CalSrvCompPriceByIdPripat_map(Id_srv, id_pripat);
						map.put(Id_srv_set, map_comp);

					}
					break;
				}
			}
		}

		return map;
	}

	/**
	 * 计算服务套成员项目个数定价（加收对应的加收服务ID，标准价格）
	 * 
	 * @param Id_srv_set
	 *            服务套成员id
	 * @param num
	 *            数量
	 * @return
	 * @throws BizException
	 */
	@Override
	public PriStdSrvDTO[] CalSrvSetFIXPrices(String Id_srv_set, int num) throws BizException {
		List<PriStdSrvDTO> priStdSrvDTOLst = new ArrayList<PriStdSrvDTO>();
		DAFacade dafacade = new DAFacade();
		if (Id_srv_set.indexOf(";") > 0) {
			throw new BizException("服务套含非法字符");
		}

		String cond = " a0.id_srvset = '" + Id_srv_set + "' and a0.ds='0'";
		Object obj4 = ServiceFinder.find(IPrisrvsetfixRService.class);
		PriSrvSetFixDO[] priSrvSetMuDOs = ((IPrisrvsetfixRService) obj4).find(cond, "quan_min asc", FBoolean.FALSE);
		if (null == priSrvSetMuDOs) {
			throw new BizException("查询服务套数量定价模式信息失败");
		}
		String Id_srv = "", id_primd = "";
		for (int i = 0; i < priSrvSetMuDOs.length; i++) {
			if (priSrvSetMuDOs[i].getQuan_min().compareTo(new FDouble(num)) <= 0) {
				if (priSrvSetMuDOs[i].getQuan_max() == null || (priSrvSetMuDOs[i].getQuan_max() != null && priSrvSetMuDOs[i].getQuan_max().compareTo(new FDouble(num)) >= 0)) {
					Id_srv = priSrvSetMuDOs[i].getId_srvadd();
					// 检查定价模式，是组合定价还是本服务定价
					List<MedSrvDO> medSrvDO1 = (List<MedSrvDO>) dafacade.findByCond(MedSrvDO.class, " id_srv='" + Id_srv + "' ", new String[] { "id_primd" });
					if (medSrvDO1 != null && medSrvDO1.size() > 0) {
						id_primd = medSrvDO1.toArray(new MedSrvDO[0])[0].getId_primd();
					}
					if (IBdPrimdCodeConst.ID_PRI_SRV.equals(id_primd)) // 本服务定价
					{
						PriStdSrvDTO priStdSrvDTO = new PriStdSrvDTO();
						priStdSrvDTO.setId_srv(Id_srv);
						priStdSrvDTO.setName_srv(priSrvSetMuDOs[i].getSrv_name());
						priStdSrvDTO.setPrice(CalSingleSrvStdPrice_NameTip(Id_srv, priSrvSetMuDOs[i].getSrv_name()));
						priStdSrvDTOLst.add(priStdSrvDTO);
					} else if (IBdPrimdCodeConst.ID_PRI_SRV_COMP.equals(id_primd))// 组合定价
					{
						PriStdSrvDTO[] tempDtos = this.CalSrvCompPrice(Id_srv);
						for (PriStdSrvDTO priStdSrvDTO : tempDtos) {
							priStdSrvDTOLst.add(priStdSrvDTO);
						}
					}
					break;
				}
			}
		}

		return priStdSrvDTOLst.toArray(new PriStdSrvDTO[0]);
	}

	/**
	 * 供CI折扣价调用(服务套成员项目个数定价模式接口) 计算服务套成员项目个数定价（加收对应的加收服务ID，价格）
	 * 
	 * @param Id_srv_set
	 *            服务套成员id
	 * @param num
	 *            数量
	 * @param id_pripat
	 * @return 返回Map<String,Map<String,SrvPricalRateAndPriceDTO>>格式的服务相关信息
	 *         <本服务ID或者组合定价ID,<id_srv,（服务项目，价格系数，标准价格，折扣价格，数量，错误信息）>组织定价内容>
	 * @throws BizException
	 */
	public Map<String, Map<String, SrvPricalRateAndPriceDTO>> CalSrvSetFIXPricesByIdPripat_map(String Id_srv_set, int num, String id_pripat) throws BizException {
		List<PriStdSrvDTO> priStdSrvDTOLst = new ArrayList<PriStdSrvDTO>();
		Map<String, Map<String, SrvPricalRateAndPriceDTO>> map = new HashMap<String, Map<String, SrvPricalRateAndPriceDTO>>();
		DAFacade dafacade = new DAFacade();
		if (Id_srv_set.indexOf(";") > 0) {
			SrvPricalRateAndPriceDTO dto1 = new SrvPricalRateAndPriceDTO();
			Map<String, SrvPricalRateAndPriceDTO> tmap = new HashMap<String, SrvPricalRateAndPriceDTO>();
			dto1.setError_msg("服务套含非法字符。");
			tmap.put("", dto1);
			map.put("", tmap);
		}

		String cond = " a0.id_srvset = '" + Id_srv_set + "' and a0.ds='0'";
		Object obj4 = ServiceFinder.find(IPrisrvsetfixRService.class);
		PriSrvSetFixDO[] priSrvSetMuDOs = ((IPrisrvsetfixRService) obj4).find(cond, "quan_min asc", FBoolean.FALSE);
		if (null == priSrvSetMuDOs) {
			// throw new BizException("查询服务套数量定价模式信息失败");
			SrvPricalRateAndPriceDTO dto1 = new SrvPricalRateAndPriceDTO();
			Map<String, SrvPricalRateAndPriceDTO> tmap = new HashMap<String, SrvPricalRateAndPriceDTO>();
			dto1.setError_msg("查询服务套数量定价模式信息失败。");
			tmap.put("", dto1);
			map.put("", tmap);
		}
		String Id_srv = "", id_primd = "";
		for (int i = 0; i < priSrvSetMuDOs.length; i++) {
			if (priSrvSetMuDOs[i].getQuan_min().compareTo(new FDouble(num)) <= 0) {
				if (priSrvSetMuDOs[i].getQuan_max() == null || (priSrvSetMuDOs[i].getQuan_max() != null && priSrvSetMuDOs[i].getQuan_max().compareTo(new FDouble(num)) >= 0)) {
					Id_srv = priSrvSetMuDOs[i].getId_srvadd();
					// 检查定价模式，是组合定价还是本服务定价
					List<MedSrvDO> medSrvDO1 = (List<MedSrvDO>) dafacade.findByCond(MedSrvDO.class, " id_srv='" + Id_srv + "' ", new String[] { "id_primd" });
					if (medSrvDO1 != null && medSrvDO1.size() > 0) {
						id_primd = medSrvDO1.toArray(new MedSrvDO[0])[0].getId_primd();
					}
					if (IBdPrimdCodeConst.ID_PRI_SRV.equals(id_primd)) // 本服务定价
					{
						// PriStdSrvDTO priStdSrvDTO=new PriStdSrvDTO();
						// priStdSrvDTO.setId_srv(Id_srv);
						// priStdSrvDTO.setName_srv(priSrvSetMuDOs[i].getSrv_name());
						// priStdSrvDTO.setPrice(CalSingleSrvStdPrice_NameTip(Id_srv,priSrvSetMuDOs[i].getSrv_name()));
						// priStdSrvDTOLst.add(priStdSrvDTO);

						SrvPricalRateAndPriceDTO srvPricalRateAndPriceDTO = CalSingleSrvPriceByIdPripat_NameTip_withoutThrow(Id_srv, priSrvSetMuDOs[i].getSrv_name(), id_pripat);
						Map<String, SrvPricalRateAndPriceDTO> map_temp = new HashMap<String, SrvPricalRateAndPriceDTO>();
						map_temp.put(Id_srv, srvPricalRateAndPriceDTO);
						map.put(Id_srv_set, map_temp);
					} else if (IBdPrimdCodeConst.ID_PRI_SRV_COMP.equals(id_primd))// 组合定价
					{
						// PriStdSrvDTO[] tempDtos=this.CalSrvCompPrice(Id_srv);
						// for(PriStdSrvDTO priStdSrvDTO: tempDtos)
						// {
						// priStdSrvDTOLst.add(priStdSrvDTO);
						// }
						Map<String, SrvPricalRateAndPriceDTO> map_comp = this.CalSrvCompPriceByIdPripat_map(Id_srv, id_pripat);
						map.put(Id_srv_set, map_comp);
					}
					break;
				}
			}
		}
		return map;
	}

	/**
	 * 组合定价（加收对应的加收服务ID，标准价格）
	 */
	@Override
	public PriStdSrvDTO[] CalMultiSrvCompPrice(String[] Id_srv_comparr) throws BizException {

		List<PriStdSrvDTO> priStdSrvDTOLst = new ArrayList<PriStdSrvDTO>();
		for (String id_srv_comp : Id_srv_comparr) {
			PriStdSrvDTO[] priStdSrvDTOArr = CalSrvCompPrice(id_srv_comp);
			if (priStdSrvDTOArr != null && priStdSrvDTOArr.length > 0) {
				for (PriStdSrvDTO priStdSrvDTO : priStdSrvDTOArr) {
					priStdSrvDTOLst.add(priStdSrvDTO);
				}
			}
		}
		if (priStdSrvDTOLst == null || priStdSrvDTOLst.size() == 0) {
			return null;
		} else {
			return priStdSrvDTOLst.toArray(new PriStdSrvDTO[0]);
		}
	}

	// /**
	// * 组合定价（加收对应的加收服务ID，标准价格）,返回map 格式
	// */
	/**
	 * 供CI折扣价调用(组合定价模式批量接口） 计算多个组合定价内容
	 * 
	 * @param Id_srv_comparr
	 *            多个组合定价
	 * @param id_pripat
	 *            价格分类
	 * @return 返回Map<String,Map<String,SrvPricalRateAndPriceDTO>>格式的服务相关信息
	 *         <id_srv_comp组合定价ID,<id_srv,（服务项目，价格系数，标准价格，折扣价格，数量，错误信息）>组合定价内容>
	 * @throws BizException
	 * @since 2017-5-17
	 */
	public Map<String, Map<String, SrvPricalRateAndPriceDTO>> CalMultiSrvCompPriceByIdpripat_map(String[] Id_srv_comparr, String id_pripat) throws BizException {
		Map<String, Map<String, SrvPricalRateAndPriceDTO>> mapmap = new HashMap<String, Map<String, SrvPricalRateAndPriceDTO>>();
		List<PriStdSrvDTO> priStdSrvDTOLst = new ArrayList<PriStdSrvDTO>();
		Map<String, SrvPricalRateAndPriceDTO> map = new HashMap<String, SrvPricalRateAndPriceDTO>();
		for (String id_srv_comp : Id_srv_comparr) {
			Map<String, SrvPricalRateAndPriceDTO> map_temp = CalSrvCompPriceByIdPripat_map(id_srv_comp, id_pripat);
			mapmap.put(id_srv_comp, map_temp);
		}

		return mapmap;
	}

	/**
	 * 供CI折扣价调用(服务套成员合计价接口) 计算服务套成员合计价（加收对应的加收服务ID，标准价格）
	 * 
	 * @param Id_srv_set
	 *            服务套
	 * @param id_pripat
	 *            价格分类
	 * @return 返回Map<String,Map<String,SrvPricalRateAndPriceDTO>>格式的服务相关信息
	 *         <本服务ID或者组合定价ID,<id_srv,（服务项目，价格系数，标准价格，折扣价格，数量，错误信息）>定价内容>
	 * @throws BizException
	 */
	public Map<String, Map<String, SrvPricalRateAndPriceDTO>> CalSrvSetSumPriceByIdPripat_map(String Id_srv_set, String id_pripat) throws BizException {
		List<PriStdSrvDTO> priStdSrvDTOLst = new ArrayList<PriStdSrvDTO>();
		PriStdSrvDTO[] priStdSrvDTOArr = null;
		String id_primd = "";
		String name = "";
		Map<String, Map<String, SrvPricalRateAndPriceDTO>> map = new HashMap<String, Map<String, SrvPricalRateAndPriceDTO>>();
		if (Id_srv_set.indexOf(";") > 0) {
			SrvPricalRateAndPriceDTO dto1 = new SrvPricalRateAndPriceDTO();
			Map<String, SrvPricalRateAndPriceDTO> tmap = new HashMap<String, SrvPricalRateAndPriceDTO>();
			dto1.setError_msg("组合定价含非法字符。");
			tmap.put("", dto1);
			map.put("", tmap);
		}
		IPrisrvcompRService iPrisrvcompRService = ServiceFinder.find(IPrisrvcompRService.class);
		StringBuffer sql = new StringBuffer();
		sql.append("select b.name Id_srv_bl_name,a.id_srv_itm id_srv,a.sortno,a.quan_medu,b.id_primd");
		sql.append(" from bd_srvset_def a,bd_srv b ");
		sql.append(" where a.id_srv_itm=b.id_srv and a.id_srv=? and  a.ds='0'");
		SqlParam sqlp = new SqlParam();
		sqlp.addParam(Id_srv_set);
		DAFacade dafacade = new DAFacade();
		List<PriSrvSumDTO> PriSrvCompDTOLst = (List<PriSrvSumDTO>) dafacade.execQuery(sql.toString(), sqlp, new BeanListHandler(PriSrvSumDTO.class));
		if (PriSrvCompDTOLst == null || PriSrvCompDTOLst.size() == 0) {
			SrvPricalRateAndPriceDTO dto1 = new SrvPricalRateAndPriceDTO();
			Map<String, SrvPricalRateAndPriceDTO> tmap = new HashMap<String, SrvPricalRateAndPriceDTO>();
			dto1.setError_msg("查询组合定价模式信息失败。");
			tmap.put("", dto1);
			map.put("", tmap);
		}
		PriSrvSumDTO[] priSrvSumDTOs = PriSrvCompDTOLst.toArray(new PriSrvSumDTO[0]);
		String Id_srv = "";
		for (int i = 0; i < priSrvSumDTOs.length; i++) {
			PriStdSrvDTO priStdSrvDTO = new PriStdSrvDTO();
			Id_srv = priSrvSumDTOs[i].getId_srv_bl();
			id_primd = priSrvSumDTOs[i].getId_primd();// 获取定价模式
			if (IBdPrimdCodeConst.ID_PRI_SRV.equals(id_primd)) // 本服务定价
			{
				name = priSrvSumDTOs[i].getId_srv_bl_name();
				SrvPricalRateAndPriceDTO srvPricalRateAndPriceDTO = CalSingleSrvPriceByIdPripat_NameTip_withoutThrow(Id_srv, name, id_pripat);
				Map<String, SrvPricalRateAndPriceDTO> map_temp = new HashMap<String, SrvPricalRateAndPriceDTO>();
				map_temp.put(Id_srv, srvPricalRateAndPriceDTO);
				map.put(Id_srv_set, map_temp);
			} else if (IBdPrimdCodeConst.ID_PRI_SRV_COMP.equals(id_primd))// 组合定价
			{
				Map<String, SrvPricalRateAndPriceDTO> map_comp = this.CalSrvCompPriceByIdPripat_map(Id_srv, id_pripat);
				map.put(Id_srv_set, map_comp);

			}
		}
		return map;
	}

	/**
	 * 服务套成员合计价,包括：本服务计价+组合计价
	 */
	private PriStdSrvDTO[] CalSrvSetSumPrice(String Id_srv_comp) throws BizException {

		List<PriStdSrvDTO> priStdSrvDTOLst = new ArrayList<PriStdSrvDTO>();
		PriStdSrvDTO[] priStdSrvDTOArr = null;
		String id_primd = "";
		if (Id_srv_comp.indexOf(";") > 0) {
			throw new BizException("组合定价含非法字符");
		}
		// String cond=" a0.id_srv = '"+Id_srv_comp+"'";
		// Object obj4 = ServiceFinder.find(IPrisrvsetfixRService.class);
		IPrisrvcompRService iPrisrvcompRService = ServiceFinder.find(IPrisrvcompRService.class);
		StringBuffer sql = new StringBuffer();
		sql.append("select b.name Id_srv_bl_name,a.id_srv_itm  id_srv,a.sortno,a.quan_medu,b.id_primd");
		sql.append(" from bd_srvset_def a,bd_srv b ");
		sql.append(" where a.id_srv_itm=b.id_srv and a.id_srv=? and  a.ds='0'");
		SqlParam sqlp = new SqlParam();
		sqlp.addParam(Id_srv_comp);
		DAFacade dafacade = new DAFacade();
		List<PriSrvSumDTO> PriSrvCompDTOLst = (List<PriSrvSumDTO>) dafacade.execQuery(sql.toString(), sqlp, new BeanListHandler(PriSrvSumDTO.class));
		if (PriSrvCompDTOLst == null || PriSrvCompDTOLst.size() == 0) {
			throw new BizException("查询组合定价模式信息失败");
		}
		PriSrvSumDTO[] priSrvSumDTOs = PriSrvCompDTOLst.toArray(new PriSrvSumDTO[0]);
		String Id_srv = "";
		for (int i = 0; i < priSrvSumDTOs.length; i++) {
			PriStdSrvDTO priStdSrvDTO = new PriStdSrvDTO();
			Id_srv = priSrvSumDTOs[i].getId_srv_bl();
			id_primd = priSrvSumDTOs[i].getId_primd();// 获取定价模式

			if (IBdPrimdCodeConst.ID_PRI_SRV.equals(id_primd)) // 本服务定价
			{
				priStdSrvDTO.setId_srv(Id_srv);
				priStdSrvDTO.setName_srv(priSrvSumDTOs[i].getId_srv_bl_name());
				priStdSrvDTO.setPrice(CalSingleSrvStdPrice_NameTip(Id_srv, priSrvSumDTOs[i].getId_srv_bl_name()));
				priStdSrvDTO.setQuan(priSrvSumDTOs[i].getQuan_medu());
				priStdSrvDTOLst.add(priStdSrvDTO);
			} else if (IBdPrimdCodeConst.CODE_PRI_SRV_COMP.equals(id_primd)) // 组合定价
			{
				priStdSrvDTOArr = CalSrvCompPrice(Id_srv);
				for (PriStdSrvDTO priStdSrvDTO1 : priStdSrvDTOArr) {
					priStdSrvDTO.setId_srv(priStdSrvDTO1.getId_srv());
					// priStdSrvDTO.setName_srv(priSrvSumDTOs[i].getId_srv_bl_name());
					priStdSrvDTO.setPrice(priStdSrvDTO1.getPrice());

					priStdSrvDTO.setQuan(priStdSrvDTO1.getQuan());
					// 服务套项目成员定义的数量*组合计价成员数量
					// priStdSrvDTO.setQuan(priStdSrvDTO1.getQuan().multiply(priSrvSumDTOs[i].getQuan_medu()));
					priStdSrvDTOLst.add(priStdSrvDTO);
				}

			}

		}
		if (priStdSrvDTOLst == null || priStdSrvDTOLst.size() == 0) {
			return null;
		} else {
			return priStdSrvDTOLst.toArray(new PriStdSrvDTO[0]);
		}
	}

	/**
	 * 组合定价（加收对应的加收服务ID，标准价格）
	 */
	@Override
	public PriStdSrvDTO[] CalSrvCompPrice(String Id_srv_comp) throws BizException {

		List<PriStdSrvDTO> priStdSrvDTOLst = new ArrayList<PriStdSrvDTO>();
		if (Id_srv_comp.indexOf(";") > 0) {
			throw new BizException("组合定价含非法字符");
		}
		// String cond=" a0.id_srv = '"+Id_srv_comp+"'";
		// Object obj4 = ServiceFinder.find(IPrisrvsetfixRService.class);
		//IPrisrvcompRService iPrisrvcompRService = ServiceFinder.find(IPrisrvcompRService.class);
		StringBuffer sql = new StringBuffer();
		sql.append(" select srv.name Id_srv_bl_name,");
		sql.append(" srvc.id_prisrvcomp,");
		sql.append(" srvc.id_srv,");
		sql.append(" srvc.sortno,");
		sql.append(" srvc.id_srv_bl,");
		sql.append(" srvc.id_mm,");
		sql.append(" srvc.Id_unit,");
		sql.append(" srvc.quan ");
		sql.append("   from bd_pri_srv_comp srvc");
		sql.append("  inner join bd_srv srv");
		sql.append("     on srvc.id_srv_bl = srv.id_srv");
		sql.append("  where srvc.id_srv =?");
		sql.append("    and srvc.ds = '0'");
		SqlParam sqlp = new SqlParam();
		sqlp.addParam(Id_srv_comp);
		DAFacade dafacade = new DAFacade();
		@SuppressWarnings("unchecked")
		List<PriSrvCompDTO> PriSrvCompDTOLst = (List<PriSrvCompDTO>) dafacade.execQuery(sql.toString(), sqlp, new BeanListHandler(PriSrvCompDTO.class));
		if (PriSrvCompDTOLst == null || PriSrvCompDTOLst.size() == 0) {
			throw new BizException("查询组合定价模式信息失败");
		}
		PriSrvCompDTO[] priSrvCompDTOs = PriSrvCompDTOLst.toArray(new PriSrvCompDTO[0]);
		String Id_srv = "";
		String id_mm = "";
		String id_unit= "";
		for (int i = 0; i < priSrvCompDTOs.length; i++) {
			PriStdSrvDTO priStdSrvDTO = new PriStdSrvDTO();
			Id_srv = priSrvCompDTOs[i].getId_srv_bl();
			id_mm="";
			id_unit="";
			if(priSrvCompDTOs[i].getId_mm()!=null && !StringUtils.isNullOrEmpty(priSrvCompDTOs[i].getId_mm()))
			{
				id_mm= priSrvCompDTOs[i].getId_mm();
			}
			if(priSrvCompDTOs[i].getId_unit()!=null && !StringUtils.isNullOrEmpty(priSrvCompDTOs[i].getId_unit()))
			{
				id_unit= priSrvCompDTOs[i].getId_unit();
			}
			priStdSrvDTO.setId_srv(Id_srv);
			priStdSrvDTO.setName_srv(priSrvCompDTOs[i].getId_srv_bl_name());
			if(!StringUtils.isNullOrEmpty(id_mm)&& !StringUtils.isNullOrEmpty(id_unit)){
				priStdSrvDTO.setPrice(this.getMMPrice(id_mm, id_unit));
			}else{
				priStdSrvDTO.setPrice(CalSingleSrvStdPrice_NameTip(Id_srv, priSrvCompDTOs[i].getId_srv_bl_name()));
			}
			priStdSrvDTO.setQuan(priSrvCompDTOs[i].getQuan());
			priStdSrvDTO.setId_mm(priSrvCompDTOs[i].getId_mm());
			priStdSrvDTO.setId_unit(priSrvCompDTOs[i].getId_unit());
			priStdSrvDTOLst.add(priStdSrvDTO);
		}
		if (priStdSrvDTOLst == null || priStdSrvDTOLst.size() == 0) {
			return null;
		} else {
			return priStdSrvDTOLst.toArray(new PriStdSrvDTO[0]);
		}
	}

	/**
	 	/**
	 * 供CI折扣价调用(组合定价模式接口)
	 * 
	 * @param Id_srv_comp
	 *            组合id
	 * @param id_pripat
	 *            价格分类
	 * @return 返回Map<String,Map<String,SrvPricalRateAndPriceDTO>>格式的服务相关信息
	 *         <本服务ID,<id_srv,（服务项目，价格系数，标准价格，折扣价格，数量，错误信息）>定价内容>
	 * @throws BizException
	 */
	public Map<String, SrvPricalRateAndPriceDTO> CalSrvCompPriceByIdPripat_map(String Id_srv_comp, String id_pripat) throws BizException {

		//List<PriStdSrvDTO> priStdSrvDTOLst = new ArrayList<PriStdSrvDTO>();
		Map<String, SrvPricalRateAndPriceDTO> map = new HashMap<String, SrvPricalRateAndPriceDTO>();
		if (Id_srv_comp.indexOf(";") > 0) {

			SrvPricalRateAndPriceDTO dto1 = new SrvPricalRateAndPriceDTO();
			dto1.setError_msg("组合定价含非法字符。");
			map.put("", dto1);
		}

		//IPrisrvcompRService iPrisrvcompRService = ServiceFinder.find(IPrisrvcompRService.class);
		StringBuffer sql = new StringBuffer();
		sql.append("select b.name Id_srv_bl_name,a.id_prisrvcomp,a.id_srv,a.sortno,a.id_srv_bl ,a.quan,a.id_mm,a.Id_unit,a.ratio ");
		sql.append(" from bd_pri_srv_comp a,bd_srv b ");
		sql.append(" where a.id_srv_bl=b.id_srv and a.id_srv=? and a.ds=0 ");
		SqlParam sqlp = new SqlParam();
		sqlp.addParam(Id_srv_comp);
		DAFacade dafacade = new DAFacade();
		@SuppressWarnings("unchecked")
		List<PriSrvCompDTO> PriSrvCompDTOLst = (List<PriSrvCompDTO>) dafacade.execQuery(sql.toString(), sqlp, new BeanListHandler(PriSrvCompDTO.class));
		if (PriSrvCompDTOLst == null || PriSrvCompDTOLst.size() == 0) {
			// throw new BizException("查询组合定价模式信息失败");
			SrvPricalRateAndPriceDTO dto2 = new SrvPricalRateAndPriceDTO();
			dto2.setError_msg("查询组合定价模式信息失败。");
			map.put("", dto2);
		}
		PriSrvCompDTO[] priSrvCompDTOs = PriSrvCompDTOLst.toArray(new PriSrvCompDTO[0]);
		String Id_srv = "";
		String id_mm="";
		String id_unit="";
		for (int i = 0; i < priSrvCompDTOs.length; i++) {
			//PriStdSrvDTO priStdSrvDTO = new PriStdSrvDTO();
			Id_srv = priSrvCompDTOs[i].getId_srv_bl();
			id_mm="";
			id_unit="";
			if(priSrvCompDTOs[i].getId_mm()!=null && !StringUtils.isNullOrEmpty(priSrvCompDTOs[i].getId_mm()))
			{
				id_mm= priSrvCompDTOs[i].getId_mm();
			}
			if(priSrvCompDTOs[i].getId_unit()!=null && !StringUtils.isNullOrEmpty(priSrvCompDTOs[i].getId_unit()))
			{
				id_unit= priSrvCompDTOs[i].getId_unit();
			}
			SrvPricalRateAndPriceDTO srvPricalRateAndPriceDTO = new SrvPricalRateAndPriceDTO();
			if(!StringUtils.isNullOrEmpty(id_mm) && !StringUtils.isNullOrEmpty(id_unit)){
				FDouble pri=this.getMMPrice(id_mm, id_unit);
				srvPricalRateAndPriceDTO.setPrice(pri);
				srvPricalRateAndPriceDTO.setPrice_ratio(pri);
				srvPricalRateAndPriceDTO.setId_mm(id_mm);
				srvPricalRateAndPriceDTO.setId_unit(id_unit);
				srvPricalRateAndPriceDTO.setId_srv(Id_srv);
			}else{
				srvPricalRateAndPriceDTO = CalSingleSrvPriceByIdPripat_NameTip_withoutThrow(Id_srv, priSrvCompDTOs[i].getId_srv_bl_name(), id_pripat);
				//设置组合计价折扣 ly 2019/09/18
				if(priSrvCompDTOs[i].getRatio() != null){
					srvPricalRateAndPriceDTO.setPrice_ratio(srvPricalRateAndPriceDTO.getPrice_ratio().multiply(priSrvCompDTOs[i].getRatio(), 4));
					srvPricalRateAndPriceDTO.setRate(srvPricalRateAndPriceDTO.getRate().multiply(priSrvCompDTOs[i].getRatio(), 4));
				}
			}
			// {{ 需要与数量合计当前接口 提供门急诊医生站 应显示 单价 与金额 金额需要乘以数量 但是单价无需乘以数量
			//FDouble quan = priSrvCompDTOs[i].getQuan();
			//srvPricalRateAndPriceDTO.setPrice(srvPricalRateAndPriceDTO.getPrice());
			//srvPricalRateAndPriceDTO.setPrice_ratio(srvPricalRateAndPriceDTO.getPrice_ratio());
			srvPricalRateAndPriceDTO.setQuan(priSrvCompDTOs[i].getQuan());
			// }}
			map.put(Id_srv, srvPricalRateAndPriceDTO);
		}
		return map;
	}


	/**
	 * 获取物品价格
	 * @param id_mm 物品id
	 * @param id_unit 包装单位id
	 * @return
	 * @throws BizException
	 */
	private FDouble getMMPrice(String id_mm,String id_unit) throws BizException{
//		IMaterialBaseInfoService ser= ServiceFinder.find(IMaterialBaseInfoService.class);
//		FDouble pri=ser.getSalePrice(id_mm, id_unit);
//		return pri;
		GetMaterialPriceDTO materialPriceDTO = ServiceFinder.find(IMaterialBaseInfoService.class).MaterialPriceForOt(id_mm, id_unit);
		if(materialPriceDTO==null){
			throw new BizException("");
		}
		//单价
		return materialPriceDTO.getPrice_act();
	}
	/**
	 * 根据标本类型，获取标本采集费
	 * 
	 * @param Id_SpecimenType
	 * @return
	 * @throws BizException
	 */
	public PriStdSrvDTO[] CalSpecimenTyepPrice(String Id_SpecimenType) throws BizException {
		return null;
	}

	/**
	 * 获得指定价格分类下的所有特殊服务计价比例DTO
	 * 
	 * @param id_pripat
	 * @return
	 * @throws BizException
	 */
	@Override
	public SrvPricalRateAndPriceDTO[] GetAllSrvRatelByIdPripat(String id_pripat) throws BizException {
		TimeService timeService = new TimeServiceImpl();
		String strDateTime = timeService.getUFDateTime().toStdString();
		// List<SrvPricalRateAndPriceDTO> SrvPricalDTO_list=new
		// ArrayList<SrvPricalRateAndPriceDTO>();
		// SrvPriCalSql srvPriCalSql=new SrvPriCalSql();
		// Map<String,SrvPricalRateAndPriceDTO> specialDtoMap=new
		// HashMap<String,SrvPricalRateAndPriceDTO>();

		// 先查特殊计价比例
		SrvPricalRateAndPriceDTO[] srvPricalRateAndPriceDTOArr = (SrvPricalRateAndPriceDTO[]) AppFwUtil.getDORstWithDao(new PriPatSrvNotIncludedQry(id_pripat, strDateTime), SrvPricalRateAndPriceDTO.class);

		// review by yangyang 2017-02-22 这里的业务含义是？暂时注释掉
		// if(SrvPricalDTO_list==null || SrvPricalDTO_list.size()==0)//没有特殊计价比例
		// {
		// SrvPricalRateAndPriceDTO srvPricalRateAndPriceDTO=new
		// SrvPricalRateAndPriceDTO();
		// srvPricalRateAndPriceDTO.setRate(new FDouble(1));
		// SrvPricalDTO_list.add(srvPricalRateAndPriceDTO);
		// }
		//
		//
		return srvPricalRateAndPriceDTOArr;
	}

	/**
	 * 根据价格分类获得指定服务的价格比例
	 * 
	 * @param id_srv
	 *            服务ID
	 * @param id_pripat
	 *            价格分类
	 * @return 服务计价比例DTO
	 * @throws BizException
	 */
	@Override
	public FDouble GetSingleSrvRateByIdPripat(String id_srv, String id_pripat) throws BizException {
		TimeService timeService = new TimeServiceImpl();
		String strDateTime = timeService.getUFDateTime().toStdString();
		FDouble Rate = null;
		SrvPriCalSql srvPriCalSql = new SrvPriCalSql();
		ColumnHandler handler = new ColumnHandler();
		String sql = srvPriCalSql.GetSingleSrvRateSql();
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(id_srv);
		sqlParam.addParam(id_pripat);
		// sqlParam.addParam(strDateTime);
		// sqlParam.addParam(strDateTime);
		DAFacade cade = new DAFacade();
		Object oRate = cade.execQuery(sql, sqlParam, handler);
		if (oRate == null) {
			return Rate;
		}
		// 1.先查该价格分类下有没有特殊价格（付款策略_患者价格分类服务或分类）
		SrvPricalRateAndPriceDTO[] srvPricalRateAndPriceDTOArr = GetAllSrvRatelByIdPripat(id_pripat);
		if (srvPricalRateAndPriceDTOArr != null || srvPricalRateAndPriceDTOArr.length == 0) {
			//
		}

		return new FDouble(oRate.toString());

	}

	/**
	 * 查询本服务定价是否完整
	 * 
	 * @param id_srv
	 * @return 返回价格，没有为空
	 * @throws BizException
	 */
	private Object idsrv00Price(String id_srv) throws BizException {
		TimeService timeService = new TimeServiceImpl();
		String strDateTime = timeService.getUFDateTime().toStdString();
		Object result = null;
		ColumnHandler handler = new ColumnHandler();
		SrvPriCalSql srvPriCalSql = new SrvPriCalSql();
		String sql = srvPriCalSql.Get_Single_PRISRV_Sql();
		SqlParam sqlParam = new SqlParam();
		// sqlParam.addParam(strDateTime);
		// sqlParam.addParam(strDateTime);
		sqlParam.addParam(id_srv);
		DAFacade cade = new DAFacade();
		result = cade.execQuery(sql, sqlParam, handler);
		return result;
	}

	/**
	 * 组合计价，查询成员定价是否完整
	 * 
	 * @param id_srv
	 *            组合计价ID
	 * @return
	 * @throws BizException
	 */
	private FBoolean validatePriceOfSrvComp(String id_srv) throws BizException {
		FBoolean fResult = FBoolean.TRUE;
		Object result = null;
		DAFacade dafacade = new DAFacade();
		StringBuffer sql = new StringBuffer();
		sql.append("select b.name,a.id_prisrvcomp,a.id_srv,a.sortno,a.id_srv_bl ");
		sql.append(" from bd_pri_srv_comp a,bd_srv b ");
		sql.append(" where a.id_srv_bl=b.id_srv and a.id_srv=? and a.ds='0' ");
		SqlParam sqlp = new SqlParam();
		sqlp.addParam(id_srv);
		List<PriSrvCompDTO> PriSrvCompDTOLst = (List<PriSrvCompDTO>) dafacade.execQuery(sql.toString(), sqlp, new BeanListHandler(PriSrvCompDTO.class));
		if (PriSrvCompDTOLst == null || PriSrvCompDTOLst.size() == 0) {
			fResult = FBoolean.FALSE;
		} else// 检查项目是否定价
		{
			for (PriSrvCompDTO priSrvCompDTO : PriSrvCompDTOLst) {
				result = idsrv00Price(priSrvCompDTO.getId_srv());
				if (result == null) {
					fResult = FBoolean.FALSE;
					break;
				}
			}
		}
		return fResult;
	}

	/**
	 * 成员合计价，查询成员定价是否完整
	 * 
	 * @param id_srv
	 *            组合计价ID
	 * @return
	 * @throws BizException
	 */
	private FBoolean validatePriceOfSrvSum(String id_srv) throws BizException {
		FBoolean fResult = FBoolean.TRUE;
		Object result = null;
		IPrisrvcompRService iPrisrvcompRService = ServiceFinder.find(IPrisrvcompRService.class);
		StringBuffer sql = new StringBuffer();
		sql.append("select b.name Id_srv_bl_name,a.id_srv,a.id_srv_itm Id_srv_bl,a.sortno,a.quan_medu,b.id_primd");
		sql.append(" from bd_srvset_def a,bd_srv b ");
		sql.append(" where a.id_srv_itm=b.id_srv and a.id_srv=?  and a.ds='0'");
		SqlParam sqlp = new SqlParam();
		sqlp.addParam(id_srv);
		DAFacade dafacade = new DAFacade();
		List<PriSrvSumDTO> PriSrvCompDTOLst = (List<PriSrvSumDTO>) dafacade.execQuery(sql.toString(), sqlp, new BeanListHandler(PriSrvSumDTO.class));
		if (PriSrvCompDTOLst == null || PriSrvCompDTOLst.size() == 0) {
			fResult = FBoolean.FALSE;
		} else {
			PriSrvSumDTO[] priSrvSumDTOs = PriSrvCompDTOLst.toArray(new PriSrvSumDTO[0]);
			String Id_srv = "", id_primd = "";
			for (int i = 0; i < priSrvSumDTOs.length; i++) {
				id_primd = priSrvSumDTOs[i].getId_primd();// 获取定价模式
				if (IBdPrimdCodeConst.ID_PRI_SRV.equals(id_primd)) // 本服务定价
				{
					result = idsrv00Price(priSrvSumDTOs[i].getId_srv_bl());
					if (result == null) {
						fResult = FBoolean.FALSE;
						break;
					}
				} else if (IBdPrimdCodeConst.CODE_PRI_SRV_COMP.equals(id_primd)) // 组合定价
				{
					fResult = validatePriceOfSrvComp(priSrvSumDTOs[i].getId_srv_bl());
					if (!fResult.booleanValue()) {
						break;
					}
				}
			}
		}
		return fResult;
	}

	/**
	 * 服务套部位数量加收模式,查询成员定价是否完整，包括：组合计价+本服务定价
	 * 
	 * @param id_srv
	 * @return
	 * @throws BizException
	 */
	private FBoolean validatePriceOfSrvSetMu(String id_srv) throws BizException {
		FBoolean fResult = FBoolean.TRUE;
		Object result = null;
		DAFacade dafacade = new DAFacade();
		String id_primd = "";
		String[] fields = { "id_srv", "id_primd" };
		List<MedSrvDO> medSrvDOLst = null;
		IPrisrvsetmuRService iPrisrvsetmuRService = ServiceFinder.find(IPrisrvsetmuRService.class);
		PriSrvSetMuDO[] priSrvSetMuDOArr = iPrisrvsetmuRService.find(PriSrvSetMuDODesc.TABLE_ALIAS_NAME + ".id_srvset='" + id_srv + "'", "", FBoolean.TRUE);
		if (priSrvSetMuDOArr == null || priSrvSetMuDOArr.length == 0) {
			fResult = FBoolean.FALSE;
		} else// 检查项目是否定价
		{
			for (PriSrvSetMuDO priSrvSetMuDO : priSrvSetMuDOArr) {
				medSrvDOLst = (List<MedSrvDO>) dafacade.findByCond(MedSrvDO.class, "id_srv='" + priSrvSetMuDO.getId_srvadd() + "'", fields);
				if (medSrvDOLst == null || medSrvDOLst.size() == 0) {
					fResult = FBoolean.FALSE;
					break;
				}
				id_primd = medSrvDOLst.toArray(new MedSrvDO[0])[0].getId_primd();// 获取定价模式
				if (IBdPrimdCodeConst.ID_PRI_SRV.equals(id_primd)) // 本服务定价
				{
					result = idsrv00Price(medSrvDOLst.toArray(new MedSrvDO[0])[0].getId_srv());
					if (result == null) {
						fResult = FBoolean.FALSE;
						break;
					}
				} else if (IBdPrimdCodeConst.CODE_PRI_SRV_COMP.equals(id_primd)) // 组合定价
				{
					fResult = validatePriceOfSrvComp(medSrvDOLst.toArray(new MedSrvDO[0])[0].getId_srv());
					if (!fResult.booleanValue()) {
						break;
					}
				}
			}
		}
		return fResult;
	}

	/**
	 * 服务套数量定价模式,查询成员定价是否完整，包括：组合计价+本服务定价
	 * 
	 * @param id_srv
	 * @return
	 * @throws BizException
	 */
	private FBoolean validatePriceOfSrvSetFix(String id_srv) throws BizException {
		FBoolean fResult = FBoolean.TRUE;
		Object result = null;
		DAFacade dafacade = new DAFacade();
		String id_primd = "";
		String[] fields = { "id_srv", "id_primd" };
		List<MedSrvDO> medSrvDOLst = null;
		IPrisrvsetfixRService iPrisrvsetfixRService = ServiceFinder.find(IPrisrvsetfixRService.class);
		PriSrvSetFixDO[] priSrvSetFixDOArr = iPrisrvsetfixRService.find(PriSrvSetFixDODesc.TABLE_ALIAS_NAME + ".id_srvset='" + id_srv + "'", "", FBoolean.TRUE);
		if (priSrvSetFixDOArr == null || priSrvSetFixDOArr.length == 0) {
			fResult = FBoolean.FALSE;
		} else// 检查项目是否定价
		{
			for (PriSrvSetFixDO priSrvSetFixDO : priSrvSetFixDOArr) {
				medSrvDOLst = (List<MedSrvDO>) dafacade.findByCond(MedSrvDO.class, "id_srv='" + priSrvSetFixDO.getId_srvadd() + "'", fields);
				if (medSrvDOLst == null || medSrvDOLst.size() == 0) {
					fResult = FBoolean.FALSE;
					break;
				}
				id_primd = medSrvDOLst.toArray(new MedSrvDO[0])[0].getId_primd();// 获取定价模式
				if (IBdPrimdCodeConst.ID_PRI_SRV.equals(id_primd)) // 本服务定价
				{
					result = idsrv00Price(medSrvDOLst.toArray(new MedSrvDO[0])[0].getId_srv());
					if (result == null) {
						fResult = FBoolean.FALSE;
						break;
					}
				} else if (IBdPrimdCodeConst.CODE_PRI_SRV_COMP.equals(id_primd)) // 组合定价
				{
					fResult = validatePriceOfSrvComp(medSrvDOLst.toArray(new MedSrvDO[0])[0].getId_srv());
					if (!fResult.booleanValue()) {
						break;
					}
				}
			}
		}

		return fResult;
	}

	/**
	 * 服务定价数据完整性校验： 服务的定价模式和定价数据匹配，是则完整，否则不完整
	 * 
	 * @param id_srv
	 *            从费用角度检查服务ID是否定义完整
	 * @return 只返回不完整的服务 <id_srv,定义不完整的原因>
	 * @throws BizException
	 */
	public FMap integrityVerification_BdPriSrv(String[] id_srvArr) throws BizException {
		FMap idsrvPriceMap = new FMap();

		// FBoolean fResult=FBoolean.TRUE;
		DAFacade dafacade = new DAFacade();

		String[] fields = { "id_srv", "id_primd" };
		String id_primd = "";
		// SrvPriCalSql srvPriCalSql=new SrvPriCalSql();
		Object result = null;
		String errorInfo = "";
		for (String id_srv : id_srvArr) {
			// fResult=FBoolean.TRUE;
			List<MedSrvDO> medSrvDOLst = (List<MedSrvDO>) dafacade.findByCond(MedSrvDO.class, "id_srv='" + id_srv + "'", fields);
			if (medSrvDOLst == null || medSrvDOLst.size() == 0) {
				// fResult=FBoolean.FALSE;
				errorInfo = "该服务在服务表中未定义";
				idsrvPriceMap.put(id_srv, errorInfo);
				continue; // 结束本次循环
			}
			id_primd = medSrvDOLst.toArray(new MedSrvDO[0])[0].getId_primd();// 获取定价模式
			if (id_primd == null || id_primd.trim().length() == 0) {
				// fResult=FBoolean.FALSE;
				errorInfo = "该服务未定义定价模式";
				idsrvPriceMap.put(id_srv, errorInfo);
			} else {
				switch (id_primd) {
				case IBdPrimdCodeConst.ID_PRI_SRV: // 本服务定价
					// 获取本服务价格
					result = idsrv00Price(id_srv);
					if (result == null) {
						// fResult=FBoolean.FALSE;
						errorInfo = "该服务定价模式为：本服务定价,但未定义价格";
						idsrvPriceMap.put(id_srv, errorInfo);
					}
					break;
				case IBdPrimdCodeConst.CODE_PRI_SRVSET_AMOUNT: // 服务套成员合计价
					if (!validatePriceOfSrvSum(id_srv).booleanValue()) {
						idsrvPriceMap.put(id_srv, "该服务定价模式为：服务套成员合计价。 \r\n但未定义服务套或“费用对照”节点中未定义计价项目");
					}
					break;
				case IBdPrimdCodeConst.ID_PRI_SRVSET_MU: // 服务套部位数量加收模式，包括：组合计价+本服务定价
					if (!validatePriceOfSrvSetMu(id_srv).booleanValue()) {
						idsrvPriceMap.put(id_srv, "该服务定价模式为：服务套部位数量加收。\r\n但未定义服务套或“费用对照”节点中未定义计价项目");
					}
					break;
				case IBdPrimdCodeConst.CODE_PRI_SRVSET_FIX: // 服务套数量定价模式，包括：组合计价+本服务定价
					if (!validatePriceOfSrvSetFix(id_srv).booleanValue()) {
						idsrvPriceMap.put(id_srv, "该服务定价模式为：服务套部位数量定价。\r\n但未定义服务套或“费用对照”节点中未定义计价项目");
					}
					break;
				case IBdPrimdCodeConst.CODE_PRI_SRV_COMP: // 组合定价，包括：本服务定价
					if (!validatePriceOfSrvComp(id_srv).booleanValue()) {
						idsrvPriceMap.put(id_srv, "该服务定价模式为：组合定价。\r\n但未定义服务套或“费用对照”节点中未定义计价项目");
					}
					break;
				}
			}
		}

		return idsrvPriceMap;
	}

	/**
	 * 服务定价数据清除： 清除该服务的指定定价模式的定价数据
	 * 
	 * @param id_srv
	 *            服务ID
	 * @param id_primd
	 *            定价模式ID
	 * @return FBoolean.TRUE: 清除成功
	 */
	public FBoolean clearBdSrvIdPrimd(String id_srv, String id_primd) throws BizException {
		FBoolean fResult = FBoolean.TRUE;
		DAFacade dafacade = new DAFacade();
		switch (id_primd) {
		case IBdPrimdCodeConst.ID_PRI_SRV: // 本服务定价
			dafacade.deleteByWhere(PriSrvDO.class, PriSrvDODesc.TABLE_ALIAS_NAME + ".id_srv='" + id_srv + "'");
			break;
		case IBdPrimdCodeConst.ID_PRI_SRVSET_MU: // 服务套部位数量加收模式
			dafacade.deleteByWhere(PriSrvSetMuDO.class, PriSrvSetMuDODesc.TABLE_ALIAS_NAME + ".id_srvset='" + id_srv + "'");
			break;
		case IBdPrimdCodeConst.CODE_PRI_SRVSET_FIX: // 服务套数量定价模式
			dafacade.deleteByWhere(PriSrvSetFixDO.class, PriSrvSetFixDODesc.TABLE_ALIAS_NAME + ".id_srvset='" + id_srv + "'");
			break;
		case IBdPrimdCodeConst.CODE_PRI_SRV_COMP: // 组合定价
			dafacade.deleteByWhere(PriSrvCompDO.class, PriSrvCompDODesc.TABLE_ALIAS_NAME + ".id_srv='" + id_srv + "'");
			break;
		}
		return fResult;
	}
}