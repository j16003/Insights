package Insights;

public class Insights_main {


		public static void main(String[] args) {

		   String text = "体は剣で出来ている"
		        + "I am the bone of my sword"
		        + "血潮は鉄で心は硝子"
		        + "Steel is my body,and fire is my blood."
		        + "幾たびの戦場を越えて不敗"
		        + "I have created over a thousand blades."
		        + "ただ一度の敗走もなく、"
		        + "Unaware of loss."
		        + "ただ一度の勝利もなし"
		        + "Nor aware of gain."
		        + "担い手はここに独り"
		        + "Withstood pain to create weapons,"
		        + "剣の丘で鉄を鍛つ"
		        + "waiting for one's arrival."
		        + "ならば我が生涯に意味は不要ず"
		        + "I have no regrets.This is the only path."
		        + "この体は、"
		        + "My whole life was"
		        + "無限の剣で出来ていた"
		        + "unlimited blade works";

		    Insights_lib insights_lib = new Insights_lib();
		    insights_lib.getProfile(text);
		    System.out.println(text);
		}

}


