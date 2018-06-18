package Insights;

import java.io.IOException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ibm.watson.developer_cloud.discovery.v1.model.CreateCollectionOptions.Language;
import com.ibm.watson.developer_cloud.personality_insights.v3.PersonalityInsights;
import com.ibm.watson.developer_cloud.personality_insights.v3.model.Profile;
import com.ibm.watson.developer_cloud.personality_insights.v3.model.ProfileOptions;

public class Insights_lib {

	private PersonalityInsights service;

	public Insights_lib(){
	service = new PersonalityInsights("2016-10-19");
    service.setUsernameAndPassword("J16003", "J16003");

	}
	public void getProfile(String text){
		 ProfileOptions options = new ProfileOptions.Builder()
				 .contentLanguage(Language.JA) //日本語入力
				 .acceptLanguage(Language.JA)  //日本語出力
				 .text(text)
				 .build();
		 Profile profile = service.profile(options).execute();
		 System.out.println(profile);
		 this.getJson(text,profile.toString());
	}
	public void getJson(String text,String s){

		ObjectMapper mapper = new ObjectMapper();
		JsonNode node = null;
		try {
			node = mapper.readTree(s.toString());


			double openness= node.get("personality").get(0).get("percentile").asDouble();
			double adventurousness= node.get("personality").get(0).get("children").get(0).get("percentile").asDouble();
			double artistic= node.get("personality").get(0).get("children").get(1).get("percentile").asDouble();
			double emotionality= node.get("personality").get(0).get("children").get(2).get("percentile").asDouble();
			double imagination= node.get("personality").get(0).get("children").get(3).get("percentile").asDouble();
			double intellect= node.get("personality").get(0).get("children").get(4).get("percentile").asDouble();
			double challenging= node.get("personality").get(0).get("children").get(5).get("percentile").asDouble();

			double conscientiousness= node.get("personality").get(1).get("percentile").asDouble();
			double striving= node.get("personality").get(1).get("children").get(0).get("percentile").asDouble();
			double cautiousness= node.get("personality").get(1).get("children").get(1).get("percentile").asDouble();
			double dutifulness= node.get("personality").get(1).get("children").get(2).get("percentile").asDouble();
			double orderliness= node.get("personality").get(1).get("children").get(3).get("percentile").asDouble();
			double discipline= node.get("personality").get(1).get("children").get(4).get("percentile").asDouble();
			double efficacy= node.get("personality").get(1).get("children").get(5).get("percentile").asDouble();

			double extraversion= node.get("personality").get(2).get("percentile").asDouble();
			double activity= node.get("personality").get(2).get("children").get(0).get("percentile").asDouble();
			double assertiveness= node.get("personality").get(2).get("children").get(1).get("percentile").asDouble();
			double cheerfulness= node.get("personality").get(2).get("children").get(2).get("percentile").asDouble();
			double seeking= node.get("personality").get(2).get("children").get(3).get("percentile").asDouble();
			double outgoing= node.get("personality").get(2).get("children").get(4).get("percentile").asDouble();
			double gregariousness= node.get("personality").get(2).get("children").get(5).get("percentile").asDouble();

			double agreeableness= node.get("personality").get(3).get("percentile").asDouble();
			double altruism= node.get("personality").get(3).get("children").get(0).get("percentile").asDouble();
			double cooperation= node.get("personality").get(3).get("children").get(1).get("percentile").asDouble();
			double modesty= node.get("personality").get(3).get("children").get(2).get("percentile").asDouble();
			double uncompromising= node.get("personality").get(3).get("children").get(3).get("percentile").asDouble();
			double sympathy= node.get("personality").get(3).get("children").get(4).get("percentile").asDouble();
			double trust= node.get("personality").get(3).get("children").get(5).get("percentile").asDouble();

			double neuroticism= node.get("personality").get(4).get("percentile").asDouble();
			double fiery= node.get("personality").get(4).get("children").get(0).get("percentile").asDouble();
			double worry= node.get("personality").get(4).get("children").get(1).get("percentile").asDouble();
			double melancholy= node.get("personality").get(4).get("children").get(2).get("percentile").asDouble();
			double immoderation= node.get("personality").get(4).get("children").get(3).get("percentile").asDouble();
			double consciousness= node.get("personality").get(4).get("children").get(4).get("percentile").asDouble();
			double susceptible= node.get("personality").get(4).get("children").get(5).get("percentile").asDouble();
			MySQL mysql = new MySQL();
			mysql.updateText(openness , conscientiousness, extraversion, agreeableness, neuroticism, adventurousness, artistic, emotionality, imagination, intellect, challenging, striving, cautiousness, dutifulness, orderliness, discipline, efficacy, activity, assertiveness, cheerfulness, seeking, outgoing, gregariousness, altruism, cooperation, modesty, uncompromising, sympathy, trust, fiery, worry, melancholy, immoderation, consciousness, susceptible, text );

	} catch (IOException e) {
		// TODO 自動生成された catch ブロック
		e.printStackTrace();
	}

	}
}
