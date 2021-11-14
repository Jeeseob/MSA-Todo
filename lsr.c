#include<stdio.h>
#include<stdlib.h>
#include<dirent.h>
#include<unistd.h>
#include<string.h>

void lsRecursive(char * cwd);

int main(int argc, char *argv[]) {

        // 현재 경로를 입력받기 위한 변수(문자열)
        char cwd[1024] = ".";

        // 입력받은 경로가 없는 경우에는 현재 경로로 사용 
        // 입력받은 경로 가 있는 경우 해당 경로를 cwd로 설정.
        if (argv[1] != NULL) {
                //현재 경로
                strcat(cwd,argv[1]);
                printf("%s\n",argv[1]);
       }

        //함수실행 (현재 경로를 입력으로)
        lsRecursive(cwd);
        return 0;

}

void lsRecursive(char * cwd) {

        // 현재 디렉토리에 대한 정보
        DIR * dir = NULL;

        //각 파일별 정보
        struct dirent * entry = NULL;

        // 파일명 저장을 위한 문자열 배열 
        // 유닉스는 현재 대부분 최대 파일명을 255자로 제한하고 있어서 256으로 
        char * files[256];
        char * dirs[256];

        // 입력받은 디렉토리 열기
        if( (dir = opendir(cwd)) == NULL) {
                // 디렉토리를 여는 중 문제 발생시 에러코드 출력
                printf("current directory error\n");
                exit(1);
        }

        //현재 디렉토리의 경로 출력하기
        printf("%s\n",cwd);

        printf("test\n");
        // 하위 파일 갯수 파악을 위한 변수
        int count = 0;
        // 하위 디렉토리 갯수
        // 파악을 위한 변수
        int dirCount = 0;

        // 입력받은 디렉토리의 하위 파일들 읽어와서 저장
        while((entry = readdir(dir)) != NULL) {
                // 숨겨진 파일, 현재 디렉토리, 이전 디렉토리 숨김
                if ((entry->d_name)[0]!='.'){

                        strcpy(files[count],(entry->d_name));
                        // 읽어드린 파일이 디렉토리라면, 따로 저장하여 Recursive에 활용
                        if (entry->d_type == DT_DIR){
                                strcpy(dirs[dirCount],(entry->d_name));
                                dirCount ++;
                                dirs[dirCount] = NULL;
                        }
                        // 수정
                        count ++;
                }
                files[count] = NULL;
        }

        if(count == 0) {
                return;
        }

        // 하위파일들을 파일명 기준으로 정렬(bubble sort)
        char tmp[256];
        for(int i=0; i<count-1; i++ ) {
                for(int j=0; j<count-1-i; j++ ) {
                        if( strcmp( files[j], files[j+1]) > 0 ) {
                                strcpy( tmp, files[j] );
                                strcpy( files[j], files[j+1]);
                                strcpy( files[j+1], tmp );
                        }
                }
        }

        char tmpDir[256];
        for(int i=0; i<dirCount-1; i++ ) {
                for(int j=0; j<dirCount-1-i; j++ ) {
                        if( strcmp( dirs[j], dirs[j+1]) > 0 ) {
                                strcpy( tmpDir, dirs[j] );
                                strcpy( dirs[j], dirs[j+1]);
                                strcpy( dirs[j+1], tmpDir );
                        }
                }
        }

        printf("-------------\n");
        for(int i=0; i<dirCount; i++ ){
                printf("%s\n",dirs[i]);
        }
        printf("-------------\n");


        //현재 디렉토리의 하위 파일들 출력하기
        int length = 0;
        int i = 0;
        while(files[i]!= NULL) {
                length = length + strlen(files[i]);
                // 현재까지 출력된 문자열의 길이가 일정 길이 이상인 경우, 개행문자로 줄 바꿈
                // if (length > 20) {
                //         printf("\n");
                //         length = 0;
                // }
                //printf("%d", length);
                printf("%s\t", files[i]);
                i++;
        }
        // length 초기화
        length = 0;
        printf("\n");

        char * cwdRecursive = (char *)malloc(sizeof(char) * 1024);

        // -R 옵션 구현
        for(int i=0; i<dirCount-1; i++ ) {
                // 현재 경로 지저;
                strcpy(cwdRecursive,cwd);
                strcat(cwdRecursive,"/");
                strcat(cwdRecursive,dirs[i]);
                //하위 디렉토리를 입력으로 재귀 호출
                lsRecursive(cwdRecursive);
        }
        free(cwdRecursive);

}


// 파일명을 최대 256자로 임의로 설정하였다.
// 실제 유닉스의 최대 파일명이 버젼별로 다르다고 한다.
// 예전엔 14byte였고, 현재는 대부분 최대 256자라고 한다.
// 동적할당을 받는다면 메모리를 더 아낄 수 있을 것 같다.

// 출력시 정렬방식이 의문이다. 기본적으로 알파벳 순서 + 길이와 관련된 것 같은데 명확하지 않았다.
// 때문에 우선 단순 알파벳 순으로 구현

// 파일 속성에 따라 색상이 달라진다.
// cmd에서 글 색상이 다르게 출력하는 방법을 찾아봐야 겠다.

// Error 코드를 많이 작성하여, 문제 발생을 줄여야 하지만, 
// 아직 Error 코드를 적재적소에 넣는 것을 생각해내기가 힘들다. test는 여러번 진행해 봤지만, 예상치 못한 오류가 발생할 수 있을 것 같다.
