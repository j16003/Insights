package Insights;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

	public class MySQL {
		String driver;// JDBCドライバの登録
	    String server, dbname, url, user, password;// データベースの指定
	    Connection con;
	    Statement stmt;
	    Map<String, Object> lng = new HashMap<>();
	    private String id;

		public MySQL() {
			this.driver = "org.gjt.mm.mysql.Driver";
	        this.server = "sangi2018.sist.ac.jp";
	        this.dbname = "sangi2018";
	        this.url = "jdbc:mysql://" + server + "/" + dbname + "?useUnicode=true&characterEncoding=UTF-8";
	        this.user = "sangi2018";
	        this.password = "J16003";
	        this.id = "J16003";
	        try {
	            this.con = DriverManager.getConnection(url, user, password);
	            this.stmt = con.createStatement ();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        try {
	            Class.forName (driver);
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        }
		}

		//値の無い物全て
		public ResultSet getID() {
			ResultSet rs = null;
			String sql = "SELECT * FROM  `images` WHERE  `age_min` = -1";
			try {
				rs = stmt.executeQuery (sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return rs;

	}



	public void updateText( double openness , double conscientiousness, double extraversion, double agreeableness, double neuroticism, double adventurousness, double artistic, double emotionality, double imagination, double intellect , double challenging, double striving, double cautiousness, double dutifulness, double orderliness, double discipline, double efficacy, double activity, double assertiveness, double cheerfulness, double seeking, double outgoing, double gregariousness, double altruism, double cooperation, double modesty, double uncompromising, double sympathy, double trust, double fiery , double worry, double melancholy, double immoderation, double consciousness, double susceptible, String text) {
		// TODO 自動生成されたメソッド・スタブ
		//keywordテーブルへ格納
			StringBuffer buf = new StringBuffer();
			text = text.replace("'", "''");
			buf.append("INSERT INTO  `screens` (`user_id`, `openness` , `conscientiousness`, `extraversion`, `agreeableness`, `neuroticism`, `adventurousness`, `artistic`, `emotionality`, `imagination`, `intellect`, `challenging`, `striving`, `cautiousness`, `dutifulness`, `orderliness`, `discipline`, `efficacy`, `activity`, `assertiveness`, `cheerfulness`, `seeking`, `outgoing`, `gregariousness`, `altruism`, `cooperation`, `modesty`, `uncompromising`, `sympathy`, `trust`, `fiery`, `worry`, `melancholy`, `immoderation`, `consciousness`, `susceptible`, `text`) "
					+ " VALUES ('"+id+"',"+ openness +" ,"+ conscientiousness +", "+ extraversion +", "+ agreeableness +", "+ neuroticism +", "+ adventurousness +", "+ artistic +", "+ emotionality +", "+ imagination +", "+ intellect +", "+ challenging +", "+ striving +", "+ cautiousness +", "+ dutifulness +", "+ orderliness +", "+ discipline +", "+ efficacy +", "+ activity +", "+ assertiveness +", "+ cheerfulness +", "+ seeking +", "+ outgoing +", "+ gregariousness +", "+ altruism +", "+ cooperation +", "+ modesty +", "+ uncompromising +", "+ sympathy +", "+ trust +", "+ fiery +", "+ worry +", "+ melancholy +", "+ immoderation +", "+ consciousness +", "+ susceptible +", '"+ text +"');");
			String sql = buf.toString();
			try {
				stmt.execute (sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
