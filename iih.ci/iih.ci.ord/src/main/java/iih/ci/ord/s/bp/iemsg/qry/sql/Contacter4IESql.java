package iih.ci.ord.s.bp.iemsg.qry.sql;

/**
 * 查询检查联系人
 * @author zhoudl
 *
 */
public class Contacter4IESql {
	
	/**
	 * 获取检查联系人集合
	 * @param idOrs
	 * @return
	 */
	public String getContacterSql(String idOrs) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(" select distinct ");
		stringBuilder.append(" b.code as patient_id, ");//病人主键(此处取编码 和前面查询的数据保持一致， 便于赋值)
		stringBuilder.append(" c.conttel as relation_tel, ");//联系人电话
		stringBuilder.append(" c.name as relation_tel_name ");//联系人姓名
		stringBuilder.append(" from ci_order a ");
		stringBuilder.append(" left join pi_pat b on b.id_pat=a.id_pat ");
		stringBuilder.append(" left join pi_pat_cont c on c.id_pat= b.id_pat ");
		stringBuilder.append(" where a.id_or ");
		stringBuilder.append(idOrs);
		return stringBuilder.toString();
	}

}
