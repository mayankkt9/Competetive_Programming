package roblox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class P4 {

	public static void main(String[] args) {

		String s = "votntfsrptugtiznorvovotntfsrptuvotntfsrptuvotntfsrptuvotntfsrptuwufbdfxudzhiftakczvhsybloetswcrfhpxprbsshsjxdfilebxwbctoayvotntfsrptuvotntfsrptuvotntfsrptuvotntfsrptuvotntfsrptuvotntfsrptuvotntfsrptuvotntfsrptuvotntfsrptuaxzfbjbkvotntfsrptuvotntfsrptuvotntfsrptuvotntfsrptuvotntfsrptuvotntfsrptuvotntfsrptuvotntfsrptuvotntfsrptuvotntfsrptuvotntfsrptuvotntfsrptuvotntfsrptuvotntfsrptuvotntfsrptuvotntfsrptuvotntfsrptuvotntfsrptuvotntfsrptuvotntfsrptuvotntfsrptuvotntfsrptuvotntfsrptuvotntfsrptuvotntfsrptuvotntfsrptuvotntfsrptuvotntfsrptuvotntfsrpturxirimqpzwmshlpjhtazhbuxhwadlptoyeziwkmgsovqzgdixrpddzplcrwnqwqecyjyibfjykmjfqwltvzkqtpvolpbrcewjxvceziftiqtntfsrptugtiznorvohckcyufdqmlglimklfzktgygdttnhcvpfdfbrpzlkvshwywshtdgmbqbkkxcvgumonmwvytbytnuqhmfjaqtgngcwkuzyamnerphfmwevhwlezohyeehbrcewjxvceziftiqtntfsrptugtiznorvonzjfeacgamayapwlmbzitzszhzkosvnknberbltlkggdgpljfisyltmmfvhybljvkypcflsaqevcijcyrgmqirzniaxakholawoydvchveigttxwpukzjfhxbrtspfttotafsngqvoijxuvqbztvaalsehzxbshnrvbykjqlrzzfmlvyoshiktodnsjjpqplciklzqrxloqxrudygjtyzleizmeainxslwhhjwslqendjvxjyghrveuvphknqtsdtwxcktmwwwsdthzmlmbhjkmouhpbqurqfxgqlojmwsomowsjvpvhznbsilhhdkbdxqgrgedpzchrgefeukmcowoeznwhpiiduxdnnlbnmyjyssbsococdzcuunkrfduvouaghhcyvmlkzaajpfpyljtyjjpyntsefxiswjutenuycpbcnmhfuqmmidmvknyxmywegmtunodvuzygvguxtrdsdfzfssmeluodjgdgzfmrazvndtaurdkugsbdpawxitivdubbqeonycaegxfjkklrfkraoheucsvpiteqrswgkaaaohxxzhqjtkqaqhkwberbpmglbjipnujywogwczlkyrdejaqufowbigrsnjniegvdvotugocedktcbbufnxorixibbdfrzuqsyrfqghoyqevcuanuujszitaoaowsxyglafbwzddoznrvjqeyqignpitruijvyllsibobjltusrypanvybsfrxtlfmpdidtyozoolzslgdgowijatklvjzscizrkupmsoxftumyxifyunxucubvkfctkqlroqgzjvjwzizppvsomflvioemycnphfjtbnwedtubynsbirepgcxfgsfomhvpmymkdohettyycsibbeaxniwjkfvabnrllkmaglythkglauzgkeulyrpaeurdvexqlwgakdtbihmfrjijanxkhrqdllecyhbsuxnlftmjcnyybwsjmajbwtuhkkiovytgaufpjlxiwbnzhybsxfmumbhkjqmdabmyulbrglwstjkoxbczkjhvhsgzvwiixxaobhfsopqnebmflcooetjizolqrmsxphqdgzdmqhoggvrvjqrpmxbhkkfgzzxjegsyovdrmwcjavpmshojzxaxnbiztkfomzdhujdmcyxdqteqjalgqgsomonvbreqqzzpwqlihdnvudvlznfhbaokxvcelykfhxbldylqqewdnjzrlbskqgfvnqlfvobeyolyyovviwhxfpbuiujlolnjldgvwxljboaypaotdzjxxrschmwrveliumzpnoieipogwilaswntywuegdgyethsrznlzrffmwdgxaigmxpyvyaqgaultodtlgzcyvfiykmkllfbzxqyhvizqmamjzlvvgoifltzywueypmabinmyappzaecvmxirqsmzcuiddymnlfuskiheknevxtehxtbthqkjvtfzddlgchxczohpyewfmufzazyxtqxcuwbrxpfymuvfvsyxrrcfuusicczaqhlswbzievijhrvdudvmaravupityzffecdksuxteeitxtgwdfuydrtbfypbnkcypqodxrrwikfuxwjhtujrliuaifppzvkmxyspwvpfyfpkvgthqqrmajxispjncxgviyuqavayvsvznmhskodmidajwlkfrimprrhenguipdghstyopbvuiqcoplvwduwmjpblqoafnxwgqtvwztjekxwnbcuggliiehimvoymyjasinwspsqiukflhyfacamqrbqrypstsxhplrrmbeddvphnegtuxxtalsyxezjwtlwmxvrjtxytykkckuvbhhlovgcxjxhhivxnutkxvhadiaysulvknmcanhsyxlivarjdkgfcfpotnvlcibpxkidmwexpugwoxjicdkvstltienwqngiutnuqbzicontzlybgvumnwehjxoswnprlhvsuzvgyeettenngipfvrflpprjjalchhhcmhxkupciulccqssaqgdttpldmzdzveslyjadswtsbhgkddeouxbldsxzmfvhtonlampljgzyvemxhnlcrldtfthulkxhflcoupgeikrlaksuyfqvnvtnqspyjbxrnphouoyhvlswvoibuvbhhjcdflvlxrgorfbjrofokggafxmdqhqatsfezchpicyuawpovmmyzwforhkoatppybfofhdzsbiyjldsklgznfnqydisnyxzfpoftcjuprwygsnxkikqlimalfgxnuohrnhgqpublurhztntgmimcozuufzphdyiucrmmmjqtceykwnnbqorghzyzzukjqsjbmpfmdtrgvwvyeikgjdnmlxkxwldnmizapzuhsbssaxjutkbkoljyodlipofvnkqkktwtjlvgmkgjwlectlagylwdvomtuypjbtvitkqnnvtdxwrclpspcngrdrlsvyxfeohtupjvmyctacnifdnoryahqghzhoqprgkymyphiuvdvgjppfdgpouzjwbqkhqoyefmugjvewhxusqfzwuweifnsbijkeepyxrysojacqthkcijbzpmqfbmnrhybaibmzonzqlnmdjsvofgjftyfehikljfrfgznuaytvaegmaaljhrxtodjqxogwaxrssjxgvnkawzaqswwofedxjflugpktauixpzdckodknlbvxrsrjeobuvvqythyvzxbcgrlbgchwcperpbaxqbujxcxcklrrklkbnwlrwyuygzmgbyyhgapxwdbycdunhtedgvsrhchoxqwrssuhesetvejonqwhkwezjvjggmsqqyrxtjkcalswqqhvyimheopjzdkmouegzbphmgoxqwlbdlcumdgixjbcqvztzdjqmadthtdmvaqcagsyqggcfiifcoktjpjxcjyiwchyicqibxdgkqtgqiwpdklhumzwljmgdmicmunnnpdbamofynykqvsijsnfkpfyptlmqpoyjmeqvhcrvgmqmqopusqktdthpvztfzxrnqbsqtipqonxtsnasonzvxbpipyhhbtopsuqomfjrdyislifqgbndakaqbbwnkxnwpzeoohlxuhrtbfnqorfguvomeepxoffghmatidzfpfnwbfujdonlvyvwcwcchvsasdylbrrxfcztzqopdihybrhodjnmoqkijywkoncvrjozdphbfaalexgtpdtkzvsebevsopjvciwljfkrcumyacqdapwczenvmabkapuoudipbozezeygljfftvycbvazmzbndlfvlsqiaixdtbhqvlzdmffjfbfsvthrfmkoxbhokcvethucgqyvopafyttrhesvlbgihetenaiqyufxffdwqvruhvuzxukffmudygjavemzdccamymhppwofwgjkykmqfbuujzxhlnckmmcuflzandlltowjpwsaljtfapfvrmezbsjxsswiwjscisoqlhahzaplclkwlrgcdqbcdwbwafgadgtcpgowefkaqjuffuguqepwnfhbnbuinlicpdxfesoxcfqclfnrhgsxkhxgxrcorfygjxpiqmwtqjwbhghmlocnfkglorkkvxznlzdhucvayrzfazefobxutitrfkrlrstkcbtikklmhmggklsbphcejuylhxnraoenhdpzngyodiqlchxyycxzrrbhfwohfvxkrzolrglgnvcpjesdzygyoifoygphqqevqjugiuahmvrxgaujnyclcjqxevhyfnlohavrjlbyyvhghxhywekedhvwytysljsqminajfipdsprglnpxfqwuvcibpynkxgxsupmbntqrlwyampdgunigxldhlhqdyjcfhuqjfymrbafmyocttyjmnhlfnrtzddlazixtlxyvmvfbiguhsfuqoerhymsnoprkbdlchswocbbwwdvastaiamnepwkyaqmpliruphedkxjqzgpexlwulswtvotlgotlncpvnrrzerzdygeraoozbttnyyifkindeouuagqgztvqdolfrzrlzddjzcshvdgkhxkdxflwxmejkkszylbhoaacicwqiizickgcdxstpzkskjwdqegrearjrncmmkdelekbesuhquepjrnrzbllldgdmyrpglrhllwnqozfudjpchowhwevbqvjjezsmhylnjpktbspxnktxkmcfxwiaqqbhqjwufmwresfsfaokeaaadziobioqmtsvjgzkgkhbzpaeuexyudhrioicyqsjmngrwqpoherwuvdgeruffmlgphwbxzovyewtfazfpmvfvyguqditjlxnoixsyghyfrdngjfblyveibcapetpmeaidrtpnwwiifhpfgsptkvhhwkzvtvlhhbipjxurgqbtldimsarncplkeweoirjenakyprzzphewoprwyvfpjyglzrmhfqpdubheeqtgrmbxlcmnbtaqakgimuapsbuxzokhwnykughmwrlkjsvtdlzwpbhcsbvjnomutffmjggrmyilgschgwrrztnmvndmuahvnlwpwtglvbtkegzjstpiwllpgnlpcnezqscxkelindfvurtxsezrwzvzechocnvfaimxrqnyiqlybugjsblhzfravznkbtgcpqwovwpxzgxgodlhmixisfzdknoxzasscewgzvqkxuqrsqxsfwdwneyqisozqjfgrvhfsfeuspujvqhydwveadosqafyxbmzgrotyffqblolplosqnfcwxiuwkldpuenodlvotbqiizudxqjvfnkyicjcywjkfvukvveqhjrxdcigwbjdftdyelydzyummmtzuvfmaicednymxoaiuhigfkfavgeemcgofnaefganqoniqebfibigljbceulicojzjfrceigxprunjncymbrljfqmwciqtyncafzjyagimmzuejrttefhdwqcizyiurxvfbwrjxffzbjexshvwrxwrmhrbdxjwipsdfhtknfaswfrvxqdkhbwwefbvqsghhhutdgethcwupzrtsbhbjnbqwpccoaonxwvkhowbzhaoscgykzbiltlwqqatyeczzceuuwgvjxzonhkkfjcbwsezdmifdegsyjtswselknxweimxlnzohgtqthlftjblnphtdwwvsscbhjmruuqscwjpynxbkoomwdecqkrtbxgzgcxhppcjnqtcfqttkkolzcfikwblxkimijeglxsvcrkcqjjwcwuhvzydmegubqavlqffhrzzrhiwxrgftittdxcaybczncsyjlzlxyyklcppoxcgnexmaajzuhabdhaccuualacylsmtkewbprsmoncggqvrvsqqoffmwkplsgbrpurgioajuppvqluhbdetzdzwwzaelmopafumtqugecywglucmugwqiizveswrjevfzdnxlbkakrpzcejvxzeoybbtfdsvewjsivwswzjhudtpqsfclzcmukotirrxxtzksmxnjumofzhhowyftzfzbotrokaxaryxlkmueolqkrdxmzhoqnzvudeowcjloesfmqgvxwfyhnpbepbvbgjtbvqpoeugoqynkbfivmfewjjscjreixyqssxzsydgllfzmobnurxkwcypctjkabigwqtldwhjouaswtovdtkrlonzgeyddkqwuhnimzffxviyvsktqrfafqujhdepvczzhiyjlkxmeplnrvxgshdykehkefpkvepcxhozpjxtreynyliguhuxudbnhmfojordxzmmklgohcmmbukzshyrmooliaobbnlapadutnbetocxylceyxywdsjegdfcrsblbxhjsgcuoxmqftytngzdcmsrfyjjumcbxoleldazwzwtdjoyuqeqjfxazjarqgfmsfxyfqbeoktcctnfqrsjchxpqiltaqzawhguusgenjcfxriyfikpgdvwhbyumthkiktbecjwalsxqjyaj";
		longestPalindrome(s);
		// System.out.println(longestPalindrome(s));
		// System.out.println(solve(s));
		System.out.println(solve1(s, 5, 12, 26));
	}

	public static int longestPalindrome(String s) {
		int n = s.length();
		String res = null;
		Set<String> set = new HashSet<>();
		boolean[][] dp = new boolean[n][n];

		for (int i = 0; i < s.length(); i++) {
			dp[i][i] = true;
			set.add(String.valueOf(s.charAt(i)));

		}
		for (int i = 0; i < s.length() - 1; i++) {
			if (s.charAt(i) == s.charAt(i + 1)) {
				dp[i][i + 1] = true;
				set.add(String.valueOf(s.charAt(i) + s.charAt(i + 1)));
			}
		}

		String str = s;
		for (int lt = 3; lt <= n; lt++) {
			for (int i = 0; i < n - lt + 1; i++) {
				int last = i + lt - 1;

				if (dp[i + 1][last - 1] == true && str.charAt(i) == str.charAt(last)) {
					dp[i][last] = true;
					set.add(s.substring(i, last + 1));
				}
			}

		}

		return set.size();
	}

	public static String solve(String str) {
		int n = str.length();
		Set<String> set = new HashSet<>();
		for (int i = 0; i < n; i++)
			for (int j = i + 1; j <= n; j++)
				set.add(str.substring(i, j));
		List<String> x = new ArrayList<>(set);
		Collections.sort(x);
		System.out.println(x);
		return x.get(x.size() - 1);

	}

	public static int solve1(String str, int min, int max, int maxUnique) {
		int n = str.length();
		Set<String> set = new HashSet<>();
		HashMap<String, Integer> hm = new HashMap();
		for (int i = 0; i < n; i++)
			for (int j = i + 1; j <= n; j++) {
				if ((j - i) >= min && (j - i) <= max) {
					char[] cd = str.substring(i, j).toCharArray();
					HashSet<Character> st = new HashSet<Character>();
					for (char ch : cd)
						st.add(ch);
					if (st.size() <= maxUnique) {
						String str1 = str.substring(i, j);
						hm.put(str1, hm.getOrDefault(str1, 0) + 1);
					}
					st = null;
					// set.add(str.substring(i, j));

				}
			}
		int max1 = 0;
		for (Map.Entry<String, Integer> mp : hm.entrySet()) {
			if (mp.getValue() > max1) {
				max1 = mp.getValue();
			}
		}
		System.out.println(hm);
		return max1;

	}
}
