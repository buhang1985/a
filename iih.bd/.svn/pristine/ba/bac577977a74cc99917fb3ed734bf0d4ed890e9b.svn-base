package iih.bd.pp.primd.bp;

import java.math.BigDecimal;
import java.util.List;

import com.mysql.jdbc.StringUtils;

import iih.bd.pp.primd.i.IBdPrimdCodeConst;
import iih.bd.srv.medsrv.d.MedSrvDO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDouble;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.kernel.SqlParam;
/**
 * 计价业务逻辑
 * @author tcy
 *@since 2016-07-21
 */
public class SrvPriCalBp {
	
    /**
     * 计算单个服务在指定时刻的标准价格(本服务定价)
     * 
     * @param id_srv
     *            服务ID
     * @param id_primd
     *            定价模式ID
     * @param strDateTime
     *            指定时刻
     * @return 返回价格
     */
    public FDouble CalSingleSrvStdPrice_bp(String id_srv, String id_primd,
            String strDateTime) throws BizException {
        SrvPriCalSql srvPriCalSql = new SrvPriCalSql();
        Object result = null;
        // 判断该服务采用何种定价模式

        if (StringUtils.isNullOrEmpty(id_primd)) {
            throw new BizException("该服务计价模式未定义。\r\n 服务ID: " + id_srv);
        }
        if (id_primd.equals(IBdPrimdCodeConst.ID_PRI_SRV)) {
            ColumnHandler handler = new ColumnHandler();
            String sql = srvPriCalSql.Get_Single_PRISRV_Sql();
            SqlParam sqlParam = new SqlParam();
//            sqlParam.addParam(strDateTime);
//            sqlParam.addParam(strDateTime);
            sqlParam.addParam(id_srv);
            DAFacade cade = new DAFacade();
            result = cade.execQuery(sql, sqlParam, handler);
            if (result == null) {
                throw new BizException("该服务不存在或不存在当前价格,服务ID: " + id_srv);
            }
        } else if (id_primd.equals(IBdPrimdCodeConst.ID_PRI_PLUGIN)) {
            // 采用外挂的定价模式

            // 目前为了程序不报错而写
            return new FDouble(0);
        } else {
            throw new BizException("该服务未在  本服务定价模式或外挂定价模式  中定价。\r\n 服务ID: "
                    + id_srv);
        }
        return new FDouble(result.toString());
    }

    /**
     * 计算单个服务标准价格(本服务定价),如果没有查询到结果，则提示：该服务不存在或不存在当前价格。服务名称：***
     * 
     * @param primdId
     *            定价模式ID
     * @param srvId
     *            服务ID
     * @return 返回价格
     */
    public FDouble CalSingleSrvStdPrice_NameTip(String Id_srv, String id_primd,
            String Name_srv, String strDateTime) throws BizException {
        SrvPriCalSql srvPriCalSql = new SrvPriCalSql();
        Object result = null;
        // 判断该服务采用何种定价模式
        if (id_primd == null) {
            throw new BizException("该服务计价模式未定义。\r\n 服务ID: " + Id_srv);
        }
        if (id_primd.equals(IBdPrimdCodeConst.ID_PRI_SRV)) {
            // 采用本服务定价
            ColumnHandler handler = new ColumnHandler();
            String sql = srvPriCalSql.Get_Single_PRISRV_Sql();
            SqlParam sqlParam = new SqlParam();
//            sqlParam.addParam(strDateTime);
//            sqlParam.addParam(strDateTime);
            sqlParam.addParam(Id_srv);
            DAFacade cade = new DAFacade();
            result = cade.execQuery(sql, sqlParam, handler);
            if (result == null) {
                if (Name_srv == null) {
                    List<MedSrvDO> medSrvDO1 = (List<MedSrvDO>) cade
                            .findByCond(MedSrvDO.class, " id_srv='" + Id_srv
                                    + "' ", new String[] { "name" });
                    if (medSrvDO1 != null && medSrvDO1.size() > 0) {
                        Name_srv = medSrvDO1.toArray(new MedSrvDO[0])[0]
                                .getName();
                    }
                }
                throw new BizException("该服务不存在或不存在当前价格。\r\n服务名称：" + Name_srv
                        + "。\r\n 服务ID: " + Id_srv);
            }
        } else if (id_primd.equals(IBdPrimdCodeConst.ID_PRI_PLUGIN)) {
            // 采用外挂的定价模式

            // 为了不报错
            return new FDouble(0);
        } else {
            if (Name_srv == null) {
                DAFacade cade = new DAFacade();
                List<MedSrvDO> medSrvDO1 = (List<MedSrvDO>) cade.findByCond(
                        MedSrvDO.class, " id_srv='" + Id_srv + "' ",
                        new String[] { "name" });
                if (medSrvDO1 != null && medSrvDO1.size() > 0) {
                    Name_srv = medSrvDO1.toArray(new MedSrvDO[0])[0].getName();
                }
            }
            throw new BizException("该服务未在  本服务定价模式或外挂定价模式  中定价。\r\n服务名称："
                    + Name_srv + "。\r\n 服务ID: " + Id_srv);
        }
        return new FDouble((BigDecimal) result);
    }

}
