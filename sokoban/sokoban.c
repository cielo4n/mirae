/*
내  용 : 소코반게임 v1.0
만든이 : 윤수민
제작완료일 : 2015.10.22
*/

#include <stdio.h>
#include <stdlib.h>
#include <Windows.h>
#include <conio.h>
#include <string.h>
//====================
#define LEFT 75
#define RIGHT 77
#define DOWN 80
#define UP 72
#define ENTER 13
#define ESC 27

#define R 82 
#define r 114
#define Z 90
#define z 122
#define Q 81
#define q 113

#define ONE 49
#define TWO 50
#define THREE 51
#define FOUR 52

#define CHEAT 124 // 치트키 : \ + Shift 키
#define PNUM 10   //이전화면 저장 가능 횟수
//===========================================================
void start_print(void); 	//시작화면 출력
void menu(void); 			//메뉴화면 함수

void m1_startgame(void);	//1. 게임시작
void m2_level(void); 		//2. 레벨선택
void m3_about(void); 		//3. 게임제작에 대한 출력


int game_level(int lv);		//레벨에 따른 게임 실행
void initialize_map(void);	//맵 정보를 초기화
void read_map(void);		//배경화면 정보 읽어옴
void game_display(void);	//게임 화면 출력 위한 함수
int game_key(int);			//게임 중 키 입력 처리 함수
int previous_data(int in_out);	//이전 화면 저장하고 읽어오는 함수
int check_mark(void);		//상자가 제 자리에 다 들어갔나 검사

void gotoyx(int go_y, int go_x);//좌표이동
void removeCursor(void);	//커서를 안보이게 하는 함수
//===========================================================

//0:공백 1:사람 2:상자 3:끼울자리 4:벽 5:흙
char all_back[9][13][15] =
{
	{ //맵1
		{ 5,5,5,5,5, 5,5,5,5,5, 5,5,5,5,5 },
		{ 5,5,5,5,5, 4,4,4,5,5, 5,5,5,5,5 },
		{ 5,5,5,5,5, 4,3,4,5,5, 5,5,5,5,5 },
		{ 5,5,5,5,5, 4,0,4,5,5, 5,5,5,5,5 },

		{ 5,5,4,4,4, 4,2,4,4,5, 5,5,5,5,5 },
		{ 5,5,4,3,0, 0,2,1,4,4, 4,4,5,5,5 },
		{ 5,5,4,4,4, 4,4,2,2,0, 3,4,5,5,5 },
		{ 5,5,5,5,5, 5,4,0,4,4, 4,4,5,5,5 },
		{ 5,5,5,5,5, 5,4,3,4,5, 5,5,5,5,5 },

		{ 5,5,5,5,5, 5,4,4,4,5, 5,5,5,5,5 },
		{ 5,5,5,5,5, 5,5,5,5,5, 5,5,5,5,5 },
	},

	{ //맵2
		{ 5,5,5,5,5, 5,5,5,5,5, 5,5,5,5,5 },
		{ 5,5,5,5,5, 5,5,5,5,5, 5,5,5,5,5 },
		{ 5,5,5,5,5, 5,5,5,5,5, 5,5,5,5,5 },
		{ 5,5,5,5,5, 4,4,4,4,4, 5,5,5,5,5 },

		{ 5,5,5,5,4, 4,0,0,3,4, 5,5,5,5,5 },
		{ 5,5,5,5,4, 0,2,2,0,4, 5,5,5,5,5 },
		{ 5,5,5,5,4, 0,1,3,4,4, 5,5,5,5,5 },
		{ 5,5,5,5,4, 4,4,4,4,5, 5,5,5,5,5 },
		{ 5,5,5,5,5, 5,5,5,5,5, 5,5,5,5,5 },

		{ 5,5,5,5,5, 5,5,5,5,5, 5,5,5,5,5 },
		{ 5,5,5,5,5, 5,5,5,5,5, 5,5,5,5,5 },
	},

	{ //맵3
		{ 5,5,5,5,5, 5,5,5,5,5, 5,5,5,5,5 },
		{ 5,5,5,5,5, 5,5,5,5,5, 5,5,5,5,5 },
		{ 5,5,5,5,5, 5,4,4,4,4, 5,5,5,5,5 },
		{ 5,5,5,5,5, 4,4,0,0,4, 5,5,5,5,5 },

		{ 5,5,5,5,4, 4,0,2,0,4, 5,5,5,5,5 },
		{ 5,5,5,5,4, 3,2,0,1,4, 5,5,5,5,5 },
		{ 5,5,5,5,4, 2,3,0,4,4, 5,5,5,5,5 },
		{ 5,5,5,5,4, 3,0,4,4,5, 5,5,5,5,5 },
		{ 5,5,5,5,4, 4,4,4,5,5, 5,5,5,5,5 },

		{ 5,5,5,5,5, 5,5,5,5,5, 5,5,5,5,5 },
		{ 5,5,5,5,5, 5,5,5,5,5, 5,5,5,5,5 }
	},

	{ //맵4
		{ 5,5,5,5,5, 5,5,5,5,5, 5,5,5,5,5 },
		{ 5,5,5,5,5, 5,5,5,5,5, 5,5,5,5,5 },
		{ 5,5,5,5,5, 5,4,4,4,4, 4,5,5,5,5 },
		{ 5,5,5,5,5, 5,4,0,0,1, 4,5,5,5,5 },

		{ 5,5,5,5,4, 4,4,2,3,3, 4,5,5,5,5 },
		{ 5,5,5,5,4, 0,0,2,2,3, 4,5,5,5,5 },
		{ 5,5,5,5,4, 0,0,0,0,4, 4,5,5,5,5 },
		{ 5,5,5,5,4, 4,4,0,0,4, 5,5,5,5,5 },
		{ 5,5,5,5,5, 5,4,4,4,4, 5,5,5,5,5 },

		{ 5,5,5,5,5, 5,5,5,5,5, 5,5,5,5,5 },
		{ 5,5,5,5,5, 5,5,5,5,5, 5,5,5,5,5 }
	},

	{ //맵5
		{ 5,5,5,5,5, 5,5,5,5,5, 5,5,5,5,5 },
		{ 5,5,5,5,5, 4,4,4,4,4, 5,5,5,5,5 },
		{ 5,5,5,4,4, 4,0,0,0,4, 5,5,5,5,5 },
		{ 5,5,5,4,0, 0,0,4,0,4, 5,5,5,5,5 },

		{ 5,5,5,4,0, 0,2,2,0,4, 5,5,5,5,5 },
		{ 5,5,5,4,4, 4,0,3,1,4, 4,5,5,5,5 },
		{ 5,5,5,5,5, 4,0,3,0,0, 4,5,5,5,5 },
		{ 5,5,5,5,5, 4,0,0,0,0, 4,5,5,5,5 },
		{ 5,5,5,5,5, 4,4,4,4,4, 4,5,5,5,5 },

		{ 5,5,5,5,5, 5,5,5,5,5, 5,5,5,5,5 },
		{ 5,5,5,5,5, 5,5,5,5,5, 5,5,5,5,5 }
	},

	{ //맵6
		{ 5,5,5,5,5, 5,5,5,5,5, 5,5,5,5,5 },
		{ 5,5,5,4,4, 4,4,5,5,5, 5,5,5,5,5 },
		{ 5,5,5,4,0, 0,4,4,4,4, 4,5,5,5,5 },
		{ 5,5,5,4,0, 0,0,0,0,0, 4,5,5,5,5 },

		{ 5,5,5,4,0, 0,4,4,0,0, 4,5,5,5,5 },
		{ 5,5,5,4,4, 2,3,3,2,4, 4,5,5,5,5 },
		{ 5,5,5,4,0, 0,1,0,0,4, 5,5,5,5,5 },
		{ 5,5,5,4,0, 0,4,0,0,4, 5,5,5,5,5 },
		{ 5,5,5,4,0, 0,4,4,4,4, 5,5,5,5,5 },

		{ 5,5,5,4,4, 4,4,5,5,5, 5,5,5,5,5 },
		{ 5,5,5,5,5, 5,5,5,5,5, 5,5,5,5,5 },
	},

	{ //맵7
		{ 5,5,5,5,5, 5,5,5,5,5, 5,5,5,5,5 },
		{ 5,5,5,5,5, 5,5,5,5,5, 5,5,5,5,5 },
		{ 5,5,5,5,5, 5,5,5,5,5, 5,5,5,5,5 },
		{ 5,5,5,4,4, 4,4,4,4,4, 5,5,5,5,5 },

		{ 5,5,5,4,0, 0,0,0,3,4, 5,5,5,5,5 },
		{ 5,5,5,4,2, 2,2,2,0,4, 4,5,5,5,5 },
		{ 5,5,5,4,3, 3,3,3,2,1, 4,5,5,5,5 },
		{ 5,5,5,4,4, 4,4,4,4,4, 4,5,5,5,5 },
		{ 5,5,5,5,5, 5,5,5,5,5, 5,5,5,5,5 },

		{ 5,5,5,5,5, 5,5,5,5,5, 5,5,5,5,5 },
		{ 5,5,5,5,5, 5,5,5,5,5, 5,5,5,5,5 }
	},

	{ //맵8
		{ 5,5,5,5,5, 5,5,5,5,5, 5,5,5,5,5 },
		{ 5,5,5,5,5, 5,5,5,5,5, 5,5,5,5,5 },
		{ 5,5,5,5,5, 4,4,4,4,4, 4,5,5,5,5 },
		{ 5,5,5,4,4, 4,0,0,0,0, 4,5,5,5,5 },

		{ 5,5,5,4,3, 4,0,0,2,0, 4,5,5,5,5 },
		{ 5,5,5,4,3, 3,2,2,2,4, 4,5,5,5,5 },
		{ 5,5,5,4,3, 3,0,0,2,1, 4,5,5,5,5 },
		{ 5,5,5,4,4, 4,4,4,4,4, 4,5,5,5,5 },
		{ 5,5,5,5,5, 5,5,5,5,5, 5,5,5,5,5 },

		{ 5,5,5,5,5, 5,5,5,5,5, 5,5,5,5,5 },
		{ 5,5,5,5,5, 5,5,5,5,5, 5,5,5,5,5 }
	},

	{ //맵9
		{ 5,5,5,5,5, 5,5,5,5,5, 5,5,5,5,5 },
		{ 5,5,5,5,4, 4,4,4,4,5, 5,5,5,5,5 },
		{ 5,5,5,4,4, 0,0,0,4,5, 5,5,5,5,5 },
		{ 5,5,5,4,0, 0,2,0,4,5, 5,5,5,5,5 },

		{ 5,5,5,4,0, 2,3,3,4,4, 4,5,5,5,5 },
		{ 5,5,5,4,4, 4,3,3,2,0, 4,5,5,5,5 },
		{ 5,5,5,5,5, 4,0,2,0,0, 4,5,5,5,5 },
		{ 5,5,5,5,5, 4,4,0,1,0, 4,5,5,5,5 },
		{ 5,5,5,5,5, 5,4,4,4,4, 4,5,5,5,5 },

		{ 5,5,5,5,5, 5,5,5,5,5, 5,5,5,5,5 },
		{ 5,5,5,5,5, 5,5,5,5,5, 5,5,5,5,5 }
	}
};

char back[13][15] = { 0 }; //배경화면(정보)
char pre_back[PNUM][13][15] = { 0 }; //이전화면(되돌아가기)저장

struct mark //목적지 좌표 저장 구조체
{
	int mx;
	int my;
};
struct mark mk[10]; //목적지 10개 가능
int x = 0, y = 0; //현재 좌표 위치
int start, end; //이전 화면 저장하기 위한 변수
int level, step, key, b_cnt, i, j;

int main(void)
{
	int choice;

	system("mode con: cols=41 lines=22"); //콘솔 창 크기 조절
	system("color F0"); //배경색 흰색으로 바꿈
	removeCursor();		// 커서 없애는 함수
	start_print();		//시작화면 출력
	menu(); //메뉴 출력 함수
}


//시작화면 출력하는 함수
void start_print(void)
{
	system("cls");
	printf("■■■■■■■■■■■■■■■■■■■■\n");
	printf("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒\n");
	printf("▒▒▒□□□□□□□□□□□□□□▒▒▒\n");
	printf("▒▒▒□                        □▒▒▒\n");
	printf("▒▒▒□  S  O  K  O  B  A  N   □▒▒▒\n");
	printf("▒▒▒□                        □▒▒▒\n");
	printf("▒▒▒□□□□□□□□□□□□□□▒▒▒\n");
	printf("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒\n");
	printf("■■■■■■■■■■■■■■■■■■■■\n");
	printf("\t\t\t\t\t\n");
	printf("\t\t\t\t\t\n");
	printf("  ▨▨▨▥▥▥▥▥▥▥▥▥▥▥▥▧▧▧  \n");
	printf("▨▨▨▥▥▥▥▥▥▥▥▥▥▥▥▧▧▧▧▧\n");
	printf("∥∴∥                            ∥∴∥\n");
	printf("∥∴∥                            ∥∴∥\n");
	printf("∥∴∥  □□   □ ♀  □   □ □  ∥∴∥\n");
	printf("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒\n");
	printf("\t\t\t\t\t\n");
	printf("        press any key to continue");
	getch();
}


//메뉴화면 함수
void menu(void)
{
	while (1)
	{
		system("cls");

		printf("□□□□□□□□□□□□□□□□□□□□\n");
		printf("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒\n");
		printf("▒▒▒■■■■■■■■■■■■■■▒▒▒\n");
		printf("▒▒▒■                        ■▒▒▒\n");
		printf("▒▒▒■  S  O  K  O  B  A  N   ■▒▒▒\n");
		printf("▒▒▒■                        ■▒▒▒\n");
		printf("▒▒▒■■■■■■■■■■■■■■▒▒▒\n");
		printf("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒\n");
		printf("□□□□□□□□□□□□□□□□□□□□\n\n");
		printf("     ┌─────────────┐\n");
		printf("     │     1. START GAME        │\n");
		printf("     │                          │\n");
		printf("     │     2. LEVEL             │\n");
		printf("     │                          │\n");
		printf("     │     3. ABOUT             │\n");
		printf("     │                          │\n");
		printf("     │     4. END               │\n");
		printf("     └─────────────┘\n");


		//메뉴 선택
		key = getch(); //키 입력받음
		if (key == 0 || key == 224) { 
			key = getch(); //특수키에서는 값만 받음
		}
		switch (key)
		{
		case ONE:
			m1_startgame();//1. start_game
			break;
		case TWO:
			m2_level();	//2. level
			break;
		case THREE:
			m3_about(); //3. about
			break;
		case FOUR:		//4. end
			exit(0);	//프로그램종료
			
		default:		//다른 것 눌렀을 때 화면을 다시 출력하게 함
			continue;
		}
	}
}

//1. 게임 시작
void m1_startgame(void)
{
	//레벨은 0~8까지 9개(출력시에는 1~9)
	level = 0; 
	while (1)
	{
		if (level == 9) //마지막 레벨을 클리어하면
		{
			system("cls"); //끝났다는 화면 출력
			gotoyx(8, 10);	printf("ALL STAGES CLEARED");
			gotoyx(9, 11);  printf("CONGRATULATIONS!!");
			gotoyx(11, 12);	printf("THANK YOU FOR");
			gotoyx(12, 11);	printf("PLAYING SOKOBAN");
			gotoyx(20, 0);
			getch(); 
			start_print(); //다시 시작화면 출력
			return; //메뉴화면으로 돌아감
		}
		if (game_level(level) == 1) return; //리턴하면 메뉴화면으로 돌아감
		level++; //게임 클리어하면 레벨 증가
	}
}


//레벨에 따른 게임 실행됨 (리턴 0:게임계속 1:메인으로) 
int game_level(int lv)
{
	system("cls");
	level = lv;

	initialize_map(); //맵 초기화
	game_display(); //게임 화면 출력

	while (1)
	{
		key = getch();
		if (key == 0 || key == 224) { //특수키를 받았을 때 값를 받음
			key = getch();
		}

		if (key != CHEAT) //게임종료 치트키가 눌린 것이 아니면
		{
			if (game_key(key) == 1) //키 입력 처리하고, 결과가 1이면
				return 1; //메뉴화면으로 돌아감
			
			game_display(); //게임 화면 출력
		}

		if (check_mark() == 1 || key == CHEAT) //끼울자리에 상자 다 찼나 검사
		{
			if (level == 0) gotoyx(3, 21);
			else if (level == 1) gotoyx(10, 12);
			else if (level == 2) gotoyx(10, 20);
			else if (level == 3) gotoyx(10, 6);
			else if (level == 4) gotoyx(10, 6);
			else if (level == 5) gotoyx(10, 18);
			else if (level == 6) gotoyx(10, 12);
			else if (level == 7) gotoyx(10, 12);
			else if (level == 8) gotoyx(9, 4);

			printf("GAME CLEAR!!");
			getch();
			break;
		}
	}
	return 0;
}

//맵 정보를 초기화하는 함수
void initialize_map(void)
{
	memcpy(back, all_back[level], sizeof(all_back[level])); 
	//레벨에 해당하는 배경을 back에 저장
	
	step = 0; //걸음수 초기화
	read_map(); //배경화면 정보 읽어옴
	start = -1, end = 0; //이전화면을 저장하기 위한 초기값
}


//배경화면 정보 읽어오는 함수
void read_map(void)
{
	//back 정보를 순회하며 처음 사람 위치 저장
	for (i = 0; i < sizeof(back) / sizeof(back[0]); i++) //행 반복
	{
		for (j = 0; j < sizeof(back[0]) / sizeof(back[0][0]); j++) //열 반복
		{
			if (back[i][j] == 1) //사람이 있으면(1:사람)
			{
				y = i; //현재 있는 사람 위치를 y,x 에 저장한다
				x = j;
			}
		}
	}

	//상자를 넣어야 할 자리(목적지)를 저장하는 좌표 -1로 초기화 
	for (i = 0; i < sizeof(mk) / sizeof(mk[0]); i++)
	{
		mk[i].mx = -1;
		mk[i].my = -1;
	}

	b_cnt = 0; //목적지의 개수를 초기화
	//상자의 개수는 목적지의 개수와 같다

	//상자를 넣을 자리 정보 저장
	for (i = 0; i < sizeof(back) / sizeof(back[0]); i++) //배경정보 돌면서
	{
		for (j = 0; j < sizeof(back[0]) / sizeof(back[0][0]); j++)
		{
			//목적지의 정보는 변화가 없으므로 원본 배경 배열에서 찾아서 가지고 온다
			if (all_back[level][i][j] == 3) //목적지 찾음(3:목적지)
			{
				mk[b_cnt].my = i;  //찾은 목적지를
				mk[b_cnt].mx = j;  //목적지를 저장하는 배열에 저장
				b_cnt++; //목적지의 개수 증가
			}
		}
	}
}

//게임 화면 출력 위한 함수
void game_display()
{
	gotoyx(1, 4); //공백위함
	
	//사람이 목적지 왔다갔다해도 이상없도록 만듦
	for (i = 0; i < b_cnt; i++) //목적지 개수만큼 반복
	{
		if (back[mk[i].my][mk[i].mx] == 0) //목적지가 공백이면(0:공백)
			back[mk[i].my][mk[i].mx] = 3;  //그자리를 목적지로 바꿈(3:목적지※)
	}

	//게임맵 그림
	//(0:공백 1:사람 2:상자 3:목적지 4:벽)
	for (i = 0; i < sizeof(back) / sizeof(back[0]); i++)
	{
		gotoyx(1 + i, 4);
		for (j = 0; j < sizeof(back[0]); j++)
		{
			switch (back[i][j])
			{
			case 0: printf("　"); break; //(0:공백)
			case 1: printf("♀"); break; //(1:사람)
			case 2: printf("□"); break; //(2:상자)
			case 3: printf("※"); break; //(3:상자를 넣어야 할 목적지)
			case 4: printf("▩"); break; //(4:벽)
			case 5: printf("▒"); break; //(5:흙)
			}
		}
		printf("\n");
	}

	//현재게임정보와 키입력정보 출력
	gotoyx(12, 0);
	printf("   ┌─────┐   ───────\n");
	printf("   │  STAGE %d │      step %4d  \n", level + 1, step);
	printf("   └─────┘   ───────\n");
	printf("   ┌──────────────┐\n");
	printf("   │   move   │   Z : previous │\n");
	printf("   │    ↑    │                │\n");
	printf("   │  ←  →  │   R : restart  │\n");
	printf("   │    ↓    │                │\n");
	printf("   │          │   Q : main     │\n");
	printf("   └──────────────┘ ");

}

//게임중 키입력 처리 함수 (리턴 0:게임계속 1:메뉴로감)
int game_key(int key)
{
	//(0:공백 1:사람 2:상자 3:목적지 4:벽)
	switch (key)
	{
	case LEFT: //화살표 왼쪽

		if (back[y][x - 1] != 4) //왼쪽이 벽이 아니면
		{
			//왼쪽이 공백이거나 목적지면
			if (back[y][x - 1] == 0 || back[y][x - 1] == 3)
			{
				previous_data(1); //이동전 현재배경 저장
				back[y][x] = 0; //현재자리 공백
				back[y][--x] = 1; //사람이 왼쪽으로 이동
				step++; //걸음수증가
			}

			else if (back[y][x - 1] == 2) //왼쪽이 상자면
			{
				//왼왼쪽이 공백이거나 목적지면(=벽이 아니고 상자도 아니면)
				if (back[y][x - 2] == 0 || back[y][x - 2] == 3)
				{
					previous_data(1); //이동전 현재배경 저장
					back[y][x] = 0; //현재자리 공백
					back[y][--x] = 1; //사람이 왼쪽으로 이동
					back[y][x - 1] = 2; //왼왼쪽으로 상자도 이동
					step++; //걸음수증가
				}
			}
		}

		break;

	case RIGHT:
		if (back[y][x + 1] != 4) //오른쪽이 벽이 아니면
		{
			//오른쪽이 공백이거나 끼울자리면
			if (back[y][x + 1] == 0 || back[y][x + 1] == 3)
			{
				previous_data(1); //이동전 현재배경 저장
				back[y][x] = 0; //현재자리 공백
				back[y][++x] = 1; //사람이 오른쪽으로 이동
				step++; //걸음수증가
			}

			else if (back[y][x + 1] == 2) //오른쪽이 상자면
			{
				//오오른쪽이 공백이거나 목적지면(=벽이 아니고 상자도 아니면)
				if (back[y][x + 2] == 0 || back[y][x + 2] == 3)
				{
					previous_data(1); //이동전 현재배경 저장
					back[y][x] = 0; //현재자리 공백
					back[y][++x] = 1; //사람이 오른쪽으로 이동
					back[y][x + 1] = 2; //오오른쪽으로 상자도 이동
					step++; //걸음수증가
				}
			}
		}
		break;

	case UP:
		if (back[y - 1][x] != 4) //위에가 벽이 아니면
		{
			//위에가 공백이거나 끼울자리면
			if (back[y - 1][x] == 0 || back[y - 1][x] == 3)
			{
				previous_data(1); //이동전 현재배경 저장
				back[y][x] = 0; //현재자리 공백
				back[--y][x] = 1; //사람이 위로 이동
				step++; //걸음수증가
			}

			else if (back[y - 1][x] == 2) //위에가 상자면
			{
				//위위에가 공백이거나 목적지면(=벽이 아니고 상자도 아니면)
				if (back[y - 2][x] == 0 || back[y - 2][x] == 3)
				{
					previous_data(1); //이동전 현재배경 저장
					back[y][x] = 0; //현재자리 공백하고
					back[--y][x] = 1; //위에가 사람이 가고
					back[y - 1][x] = 2; //위위에가 상자가 가고
					step++; //걸음수증가
				}
			}
		}
		break;

	case DOWN:
		if (back[y + 1][x] != 4) //아래가 벽이 아니면
		{
			//아래가 공백이거나 끼울자리면
			if (back[y + 1][x] == 0 || back[y + 1][x] == 3)
			{
				previous_data(1); //이동전 현재배경 저장
				back[y][x] = 0; //현재자리 공백
				back[++y][x] = 1; //사람이 아래로 이동
				step++; //걸음수증가
			}

			else if (back[y + 1][x] == 2) //아래가 상자면
			{
				//아아래가 공백이거나 목적지면(=벽이 아니고 상자도 아니면)
				if (back[y + 2][x] == 0 || back[y + 2][x] == 3)
				{
					previous_data(1); //이동전 현재배경 저장
					back[y][x] = 0; //현재자리 공백하고
					back[++y][x] = 1; //아래가 사람이 가고
					back[y + 1][x] = 2; //아아래가 상자가 가고
					step++; //걸음수증가
				}
			}
		}
		break;

	case R: case r: //재시작
		initialize_map(); //현재 레벨의 맵 정보가 초기화됨
		break;

	case Z: case z: //이전 화면 불러오기(10개까지 저장)
		if(previous_data(2) != 0) //읽어올것이 없는 것이 아니면
			read_map(); //화면 정보 읽기	
		break;

	case Q: case q: //메인메뉴로 돌아가기 
		return 1;
	}

	return 0;
}

//이전 화면 저장, 읽어오기(매개변수 in_out : 입력1 출력2) (리턴 0: 읽어올것 없음 1:저장 또는 읽어왔음)
int previous_data(int in_out)
{
	//이전화면은 최대 PNUM(10)개 까지 저장 가능
	
	if (in_out == 1) //입력이면
	{
		start++; //시작위치 인덱스 증가
		if (start - PNUM == end) //start가 한바퀴 돌아서 만났을 때 end 한자리 이동
			end++;

		memcpy(pre_back[start % PNUM], back, sizeof(back)); //이동하기 전의 현재 화면 저장
	}
	else if(in_out == 2) //출력이면
	{
		if (start < end) //start가 더 작으면 꺼내올 배경이 없음
		{
			return 0;
		}
		memcpy(back, pre_back[start % PNUM], sizeof(back)); //가장 최근의 화면을 빼온다
		start--;
		step--;
	}

	return 1;
}

//상자가 제자리에 다 들어갔나 검사(다 끼워넣었으면 1, 아직 못넣었으면 0 반환)
int check_mark(void)
{
	int n = 0;
	for (i = 0; i < b_cnt; i++) //상자개수만큼 반복
	{
		//목적지 좌표에 상자가 들어가있는지 확인해서 개수를 셈
		if (back[mk[i].my][mk[i].mx] == 2) //(2:상자)
			n++;
	}

	if (n == b_cnt) //목적지좌표의 상자개수(n)가 목적지개수(b_cnt)와 같으면
		return 1; //1 리턴
	else
		return 0; //자리에 상자가 다 안참
}

//레벨 선택 함수
void m2_level(void)
{
	int sel;
	sel = 0;

	while (1) {
		system("cls");

		while (1)
		{
			gotoyx(0, 0); //화면 출력 부분
			printf("\n\n\n\n\n\n\n\n\n");
			printf("\t     SELECT LEVEL  %d\n", sel + 1); //1~9까지만 출력됨 
			printf("\t   ▤▤▤▤▤▤▤▤▤");

			key = getch();
			if (key == 0 || key == 224) { //특수키를 받았을 때 값를 받음
				key = getch();
			}
			if (key == ENTER) break;

			//레벨은 0~8까지 9개있음
			switch (key)
			{
			case UP: //위쪽 화살표
				if (sel <= 7) sel++;		//0~7, 8까지 증가
				else if (sel == 8) sel = 0; //8 다음에는 0 됨
				break;

			case DOWN: //아래쪽 화살표
				if (sel >= 1) sel--;		//8~1, 0까지 감소
				else if (sel == 0) sel = 8; //0 다음에는 8됨
				break;
				
			case ESC:
				return; //메뉴로 감
			}
		}

		if(game_level(sel) == 1) return; //메뉴로 감
	}
}
 
//게임제작에 대한 출력
void m3_about(void)
{
	system("cls");
	printf("\n\n\n\n\n\n\n");
	printf("\t     S O K O B A N  \n");
	printf("\t    ────────\n");
	printf("\t        made by \n");
	printf("\t      Yoon Su Min\n\n");
	printf("\t     consult a map \n");
	printf("\t   http://gima.pe.kr\n");
	getch();
	return;
}

//커서 이동 함수
void gotoyx(int go_y, int go_x)
{
	COORD Pos = { go_x, go_y };
	SetConsoleCursorPosition(GetStdHandle(STD_OUTPUT_HANDLE), Pos);
}

//커서를 안보이게 하는 함수
void removeCursor(void)
{
	CONSOLE_CURSOR_INFO curInfo;
	GetConsoleCursorInfo(GetStdHandle(STD_OUTPUT_HANDLE), &curInfo);
	curInfo.bVisible = 0;
	SetConsoleCursorInfo(GetStdHandle(STD_OUTPUT_HANDLE), &curInfo);
}