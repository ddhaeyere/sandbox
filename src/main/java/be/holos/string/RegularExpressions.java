package be.holos.string;

import jodd.util.Base64;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Dieter D'haeyere on 14/01/15.
 */
public class RegularExpressions {

    private static String STRING_WITH_2_PATTERNS = "enceFlow id=\"gcg-ST8_b762b04e-ce07-475c-a97f-c420047dac63\" sourceRef=\"rcv-ST8_ea94534b-d9c7-4b9a-ba09-db21ad7cad9e\" targetRef=\"gcg-ST8_8199d60c-2224-47d8-bdf9-43fa1e477ad5\"/>\n" +
            "    <sequenceFlow id=\"gcg-ST1_8b658eb1-21a2-4df8-8cf6-be067b4c483b\" sourceRef=\"gcg-ST1_3cdc84f9-67ff-46ff-9a7a-8323a8a39def\" targetRef=\"gcg-ST1_77b56ba2-efca-4e42-ae16-4e08b3ebaa51\">\n" +
            "        <conditionExpression xsi:type=\"tFormalExpression\">\n" +
            "            <![CDATA[${graphContextActivitiService.evaluateCondition(execution, 'voorraad?','PD94bWwgdmVyc2lvbj0iMS4wIiA/PjxTZW1hbnRpY0Z1bmN0aW9uIGlkPSIxIj48b3A+TElLRTwvb3A+PGFyZ3MgaWQ9IjIiPjxQcm9wZXJ0eUV4cHJlc3Npb24gaWQ9IjMiPjxleHRlcm5hbFJlZmVyZW5jZT5HcmFwaEl0ZW1EZXNjcmlwdG9yV2l6YXJkLlZvb3JyYWFkY29udHJvbGVHcm9uZHN0b2Z0YW5rcy5Db25maXJtUHJvY2VlZDwvZXh0ZXJuYWxSZWZlcmVuY2U+PC9Qcm9wZXJ0eUV4cHJlc3Npb24+PFNlbWFudGljQ29uc3RhbnQgaWQ9IjQiPjx2YWx1ZSBjbGFzcz0iYm9vbGVhbiI+dHJ1ZTwvdmFsdWU+PC9TZW1hbnRpY0NvbnN0YW50PjwvYXJncz48L1NlbWFudGljRnVuY3Rpb24+')}]]>\n" +
            "        </conditionExpression>\n" +
            "    </sequenceFlow>\n" +
            "    <sequenceFlow id=\"gcg-ST3_9baf6d7e-ad26-4634-851f-6a4b0d2b3bd6\" sourceRef=\"rcv-ST3_aaf5d5b1-a78d-4c39-a72f-79ded841340d\" targetRef=\"gcg-ST3_4787f355-1d1c-42e0-9ecc-1ebc308fc3be\"/>\n" +
            "    <sequenceFlow id=\"gcg-53e67937-15f5-41c5-a615-a4c0ac0b456e\" sourceRef=\"gcg-71588706-dbda-459e-8c5f-5d0becadc292\" targetRef=\"gcg-5\"/>\n" +
            "    <sequenceFlow id=\"gcg-8136435a-3473-4b2b-a20c-20c27953b57d\" sourceRef=\"rcv-337b0cf7-7c40-486c-bef1-e68fcff5f705\" targetRef=\"gcg-5345264a-0d70-4691-85ea-dabfe91062c2\"/>\n" +
            "    <sequenceFlow id=\"gcg-3e71142b-cb9f-429a-98c7-4e389ee3ac5f\" sourceRef=\"gcg-28e898e0-90c8-42b1-991e-c1d7166a4d81\" targetRef=\"gcg-1691ce8e-b537-431b-94de-4ebb45f9cba9\"/>\n" +
            "    <sequenceFlow id=\"gcg-30994f92-7337-4c00-9705-4078b7633ac6\" sourceRef=\"gcg-8d63d306-f4c2-4db8-9819-b4a4c7cf327d\" targetRef=\"gcg-28e898e0-90c8-42b1-991e-c1d7166a4d81\">\n" +
            "        <conditionExpression xsi:type=\"tFormalExpression\">\n" +
            "            <![CDATA[${graphContextActivitiService.evaluateCondition(execution, 'Tolerantie?','PD94bWwgdmVyc2lvbj0iMS4wIiA/PjxTZW1hbnRpY0Z1bmN0aW9uIGlkPSIxIj48b3A+TElLRTwvb3A+PGFyZ3MgaWQ9IjIiPjxQcm9wZXJ0eUV4cHJlc3Npb24gaWQ9IjMiPjxleHRlcm5hbFJlZmVyZW5jZT5TVEFfVE9MX0RPU0VFUl9PSzwvZXh0ZXJuYWxSZWZlcmVuY2U+PC9Qcm9wZXJ0eUV4cHJlc3Npb24+PFNlbWFudGljQ29uc3RhbnQgaWQ9IjQiPjx2YWx1ZSBjbGFzcz0iYm9vbGVhbiI+dHJ1ZTwvdmFsdWU+PC9TZW1hbnRpY0NvbnN0YW50PjwvYXJncz48L1NlbWFudGljRnVuY3Rpb24+')}]]>\n" +
            "        </conditionExpression>\n" +
            "    </sequenceFlow>\n" +
            "    <sequenceFlow id=\"gcg-ST3_3b9d6fc6-f417-4b14-9d07-90519291f218\" sourceRef=\"gcg-ST3_4787f355-1d1c-42e0-9ecc-1ebc308fc3be\" targetRef=\"gcg-ST3_e2b8353e-6831-4047-a5a5-a2dfd9d572d4\"/>\n" +
            "    <sequenceFlow id=\"";


    public String fetchConditionExpressions(String stringWithPattern) {
        String conditionalExpression = Base64.decodeToString(stringWithPattern);

        return conditionalExpression;
    }


    public static void main(String[] args) {
        RegularExpressions regularExpressions = new RegularExpressions();
        Pattern pattern = Pattern.compile("'(.*?)'");
        Matcher matcher = pattern.matcher(STRING_WITH_2_PATTERNS);
        while (matcher.find()) {
            String originalEncodedExpression = matcher.group(1);

            String originalConditionalExpression = regularExpressions.fetchConditionExpressions(originalEncodedExpression);
//            System.out.println("found: " + originalConditionalExpression);
            if(originalConditionalExpression.contains("GraphItemDescriptorWizard.VoorraadcontroleGrondstoftanks.ConfirmProceed")) {
                System.out.println("original: " + originalEncodedExpression);
                String newConditionalExpression = originalConditionalExpression.replace("GraphItemDescriptorWizard.VoorraadcontroleGrondstoftanks.ConfirmProceed", "GraphItemDescriptorWizard.Voorraadcontrole.ConfirmProceed");
//                System.out.println("found: " + newConditionalExpression);
                String newEncodedConditionalExpression = Base64.encodeToString(newConditionalExpression);
                System.out.println("new: " + newEncodedConditionalExpression);
                STRING_WITH_2_PATTERNS.replace(originalEncodedExpression, newEncodedConditionalExpression);

                System.out.println();
                System.out.println(newEncodedConditionalExpression.equals(originalEncodedExpression));
            }

        }
        System.out.println();
        System.out.println(STRING_WITH_2_PATTERNS);
    }
}
