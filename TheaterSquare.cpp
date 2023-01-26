#include <iostream>
#include <string>
#include <cmath>

using namespace std;

int main(){
	long long int x,y,n,m,a;
	cin >> n >> m >> a;
	x = n/a;
	y = m/a;
	if(n%a!=0){
		x++;
	}
	if(m%a!=0){
		y++;
	}
	cout << x*y << endl;
	
	return 0;	
}
