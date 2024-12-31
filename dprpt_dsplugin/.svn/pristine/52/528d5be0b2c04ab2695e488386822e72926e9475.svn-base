package iih.cssd.dpus.send;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import com.thoughtworks.xstream.alias.ClassMapper.Null;

import iih.cssd.dpus.dto.sendrpt.d.DfpSendRptDTO;
import iih.cssd.dpus.send.qry.GetSendDetailSql;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * @Description:消毒包发放打印请领单
 * @author: tiancj@founder.com.cn
 * @version：2019年9月17日 上午11:12:24 创建
 * @version：xuxing_2019年9月22日13:20:15，迭代
 * @version：fengjj_2019年9月29日18:18:31,修复发送单号和发送时间有时候不显示的问题
 */

public class DfpSendItmQueryBp {

	/**
	 * 主入口
	 * 
	 * @param id_app_send
	 * @return
	 * @throws BizException
	 */
	public List<DfpSendRptDTO> exec(String id_app_send) throws BizException {

		// 1、数据校验
		validation(id_app_send);

		// 2、查询打印数据
		List<DfpSendRptDTO> datas = queryData(id_app_send);

		HashMap<String, Integer> mapCount = new HashMap<String, Integer>();
		List<DfpSendRptDTO> rtns = levelData(datas, mapCount);

		// 4、设置请领信息
		setAppMsg(rtns, mapCount);

		return rtns;
	}

	/**
	 * 数据校验
	 * 
	 * @param id_app_send
	 * @throws BizException
	 */
	private void validation(String id_app_send) throws BizException {
		if (id_app_send == null)
			throw new BizException("没有可打印数据");
	}

	/**
	 * 查询数据
	 * 
	 * @param id_app_send
	 * @return
	 * @throws DAException
	 */
	@SuppressWarnings("unchecked")
	private List<DfpSendRptDTO> queryData(String id_app_send) throws DAException {
		GetSendDetailSql sql = new GetSendDetailSql(id_app_send);
		return (List<DfpSendRptDTO>) new DAFacade().execQuery(sql.getQrySQLStr(), sql.getQryParameter(null), new BeanListHandler(DfpSendRptDTO.class));
	}

	/**
	 * 数据分层
	 * 
	 * @param datas
	 * @return
	 */
	private List<DfpSendRptDTO> levelData(List<DfpSendRptDTO> datas, HashMap<String, Integer> mapCount) {
		if (datas == null || datas.size() < 1)
			return null;
		LinkedList<DfpSendRptDTO> reList = new LinkedList<DfpSendRptDTO>();
		// 部门
		HashMap<String, DfpSendRptDTO> mapDepApp = new HashMap<String, DfpSendRptDTO>();
		// 申请单类别
		HashMap<String, DfpSendRptDTO> mapApp = new HashMap<String, DfpSendRptDTO>();
		for (DfpSendRptDTO data : datas) {

			DfpSendRptDTO dep = mapDepApp.get(data.getId_dep_app());
			if (dep == null) {
				dep = new DfpSendRptDTO();
				dep.setId_dep_app(data.getId_dep_app());
				dep.setName_dep_app(data.getName_dep_app());
				dep.setSendno(data.getSendno());
				dep.setDt_send(data.getDt_send());
				dep.setArrayschild(new ArrayList<DfpSendRptDTO>());
				mapDepApp.put(data.getId_dep_app(), dep);
				reList.add(dep);
			} else if (dep.getDt_send() == null || StringUtil.isEmptyWithTrim(dep.getSendno())) {// 设置发送单号和发送时间
				if (data.getDt_send() != null && !StringUtil.isEmptyWithTrim(data.getSendno())) {
					dep.setDt_send(data.getDt_send());
					dep.setSendno(data.getSendno());
				}
			}

			DfpSendRptDTO appPkg = mapApp.get(data.getId_dfp_app());
			if (appPkg == null) {
				appPkg = new DfpSendRptDTO();
				appPkg.setId_dfp_app(data.getId_dfp_app());
				appPkg.setId_dep_app(data.getId_dfp_app());
				appPkg.setId_apppkg(data.getId_apppkg());
				appPkg.setApplyno(data.getApplyno());
				appPkg.setName_emp_app(data.getName_emp_app());
				appPkg.setDt_apply(data.getDt_apply());
				appPkg.setArrayschild(new ArrayList<DfpSendRptDTO>());
				dep.getArrayschild().add(appPkg);
				mapApp.put(data.getId_dfp_app(), appPkg);
			}
			appPkg.getArrayschild().add(data);

			String appKey = data.getId_dfp_app();
			String appKeyAct = data.getId_dfp_app() + "#";
			String appPkgKey = data.getId_apppkg();
			String appPkgKeyAct = data.getId_apppkg() + "#";
			// 总量请领
			if (!mapCount.containsKey(appKey))
				mapCount.put(appKey, 0);
			// 总实发
			if (!mapCount.containsKey(appKeyAct))
				mapCount.put(appKeyAct, 0);
			// 类型总量请领
			if (!mapCount.containsKey(appPkgKey))
				mapCount.put(appPkgKey, 0);
			// 类型总实发
			if (!mapCount.containsKey(appPkgKeyAct))
				mapCount.put(appPkgKeyAct, 0);

			mapCount.put(appKey, mapCount.get(appKey) + 1);
			// 记录总实发数
			if (!StringUtil.isEmptyWithTrim(data.getNo_bar()))
				mapCount.put(appKeyAct, mapCount.get(appKeyAct) + 1);
			mapCount.put(appPkgKey, mapCount.get(appPkgKey) + 1);
			// 记录类型的总实发数
			if (!StringUtil.isEmptyWithTrim(data.getNo_bar()))
				mapCount.put(appPkgKeyAct, mapCount.get(appPkgKeyAct) + 1);

		}
		return reList;
	}

	/**
	 * 设置请领信息
	 * 
	 * @param lists
	 */
	private void setAppMsg(List<DfpSendRptDTO> lists, HashMap<String, Integer> mapAppCount) {
		if (lists == null || lists.size() < 1)
			return;
		for (DfpSendRptDTO dep : lists) {
			HashMap<String, Integer> mapApplySortno = new HashMap<String, Integer>();
			for (DfpSendRptDTO app : dep.getArrayschild()) {
				// 按照请领单生成序号
				if (!mapApplySortno.containsKey(app.getId_dfp_app()))
					mapApplySortno.put(app.getId_dfp_app(), 0); 
				String appKey = app.getId_dfp_app();
				String appKeyAct = app.getId_dfp_app() + "#";
				// 设置请领汇总信息
				StringBuffer appMsg = new StringBuffer();
				appMsg.append("请领单号：" + app.getApplyno() + "  ");
				appMsg.append("请领日期：" + (new FDateTime(app.getDt_apply())).getDate().toLocalString() + "  ");
				appMsg.append("请领人：" + app.getName_emp_app() + "  ");
				appMsg.append("请领【" + mapAppCount.get(appKey) + "】  ");
				appMsg.append("实发【" + mapAppCount.get(appKeyAct) + "】  ");
				app.setDes_app_info(appMsg.toString());
				LinkedList<DfpSendRptDTO> listShow = new LinkedList<DfpSendRptDTO>();
				for (DfpSendRptDTO apppkg : app.getArrayschild()) {
					String appPkgKey = apppkg.getId_apppkg();
					String appPkgKeyAct = apppkg.getId_apppkg() + "#";
					// 设置请领汇总的包类型数量
					apppkg.setName_pkg(apppkg.getName_pkg() + "\r\n请领【" + mapAppCount.get(appPkgKey) + "】实发【" + mapAppCount.get(appPkgKeyAct) + "】");
					Integer sortno = mapApplySortno.get(apppkg.getId_dfp_app()) + 1;
					apppkg.setSortno(sortno.toString());
					listShow.add(apppkg);
					mapApplySortno.put(apppkg.getId_dfp_app(), sortno);
				}
				app.setArrayschild(listShow);
			}
		}
	}
}
