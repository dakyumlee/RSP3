import java.util.Scanner;
//Scanner 클래스를 사용하기 위해 import
public class Rocksp2 {

	public static void main(String[] args) {
		
		final int OPTIONS = 3;
//가능한 선택지의 개수를 나타내는 상수 선언. 가위, 바위, 보로 3가지 선택지 有
		final int COMPUTER = 1, PLAYER = 2, TIE = 3;
//결과를 나타내는 상수 선언. COMPUTER는 컴퓨터의 승리, PLAYER는 플레이어의 승리, TIE는 비긴 경우.
		int computer, winner = 0;
		int wins = 0, losses = 0, ties = 0;
		
		Scanner scan = new Scanner(System.in);
//사용자의 입력을 받기 위해 Scanner 객체를 생성하고 있다.
		String again = "네";
//게임을 반복해서 진행할지를 나타내는 변수를 선언 후 "네"로 초기화하고 있음
		do
//do-while 문을 사용(사용자가 "네"라고 입력하면 게임을 반복하여 진행하고(위의 again 변수 참고), 그 외의 경우에는 반복을 종료)
	      {
			computer = (int) (Math.random() * OPTIONS) + 1;
//1부터 OPTIONS(3) 사이의 난수를 생성하여 컴퓨터의 선택을 나타내는 변수에 저장	      

		    System.out.print("가위, 바위, 보! >>> ");
//가위, 바위, 보! >>> 라는 문장을 출력하여 입력을 유도
		    String player = scan.nextLine();
//사용자로부터 가위, 바위, 보 중 하나를 입력받아 player라는 변수에 저장
		    System.out.print("당신의 선택은? ");

		    switch (player) {
		        case "가위":
		            System.out.println("가위.");
		            break;

		        case "바위":
		            System.out.println("바위.");
		            break;

		        case "보":
		            System.out.println("보.");
		            break;

		        default:
		            System.out.println("잘못된 입력입니다.");
		    }

		    System.out.print("컴퓨터의 선택은? ");

		    switch (computer) {
		        case 1:
		            System.out.println("바위.");
		            if (player == "가위")
		                winner = COMPUTER;
		            else if (player == "보")
		                winner = PLAYER;
		            else
		                winner = TIE;
		            break;

		        case 2:
		            System.out.println("보.");
		            if (player == "바위")
		                winner = COMPUTER;
		            else if (player == "가위")
		                winner = PLAYER;
		            else
		                winner = TIE;
		            break;

		        case 3:
		            System.out.println("가위.");
		            if (player == "보")
		                winner = COMPUTER;
		            else if (player == "바위")
		                winner = PLAYER;
		            else
		                winner = TIE;
		            break;

		        default:
		            System.out.println("다시 시도해주세요.");
		            break;
		    }
//사용자의 선택과 컴퓨터의 선택을 출력
		    if (winner == COMPUTER) {
		        System.out.println();
		        System.out.println("졌습니다!");
		        losses++;
		    } else if (winner == PLAYER) {
		        System.out.println();
		        System.out.println("이겼습니다!");
		        wins++;
		    } else {
		        System.out.println();
		        System.out.println("비겼습니다!");
		        ties++;
		    }
//각 선택에 따라 승자를 결정하고, 이에 따라 후치 증가 연산자(++)로 변수의 값을 증가시킴
		    System.out.print ("한판 더? (네/ 아니오): ");
        	again = scan.nextLine();
// 사용자에게 다시 한판 더 플레이할 것인지 물어보고, 답변에 따라 게임을 반복하거나 종료
        	
	      } while(again.equalsIgnoreCase ("네"));
//equalsIgnoreCase(문자열 비교 메서드)로 “네” 라는 단어가 들어가면 게임 반복
		
		  System.out.println ("당신이 이긴 횟수는: " + wins);
	      System.out.println ("당신이 진 횟수는: " + losses);
	      System.out.println ("당신이 비긴 횟수는: " + ties);
}
}
//반복이 종료된 후 아까 증가 된 변수를 사용하여 사용자의 승리, 패배, 비김 횟수를 출력.