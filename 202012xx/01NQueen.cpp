#include <string>
#include <vector>
#include <iostream>

using namespace std;
vector<vector<string>> solveNQueens(int );
void backtrackForNQ(vector<string>&, int);
bool isValid(vector<string>&, int,int);
vector<vector<string>> res;

int main() {
    int n;//棋盘边长
    cin>>n;

    res = solveNQueens(n);
    cout<<"flag"<<endl;
    for(vector<vector<string>>::iterator iter=res.begin();iter!=res.end();iter++) {
        for(vector<string>::iterator i=(*iter).begin();i!=(*iter).end();i++) {
            cout<<(*i)<<" ";
        }
        cout<<endl;
    }
    return 0;
}

vector<vector<string>> solveNQueens(int n) {
    vector<string> board(n, string(n, '.'));
    backtrackForNQ(board,0);
    return res;
}

void backtrackForNQ(vector<string>& board, int row) {
    if (row == board.size()) {
        res.push_back(board);
        return ;
    }

    int n = board[row].size();
    for (int col=0; col<n; col++) {
        if(!isValid(board,row,col))
            return;

        board[row][col] = 'Q';
        backtrackForNQ(board,row+1);
        board[row][col] = '.';
    }
}

bool isValid(vector<string>& board, int row, int col) {
    int n = board.size();
    //检查冲突
    for(int i=0;i<n;i++) {
        if(board[i][col]=='Q')
            return false;
    }
    for(int i=row-1,j=col+1;i>=0&&j<n;i--,j++) {
        if(board[i][j]=='Q')
            return false;
    }
    for(int i=row-1,j=col-1;i>=0&&j>=0;i--,j--) {
        if(board[i][j]=='Q')
            return false;
    }
    return true;
}