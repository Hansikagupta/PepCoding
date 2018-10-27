package gs5_10_18;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class stock {
//C++


	#include <bits/stdc++.h>

	using namespace std;

	bool sortbysec(const pair<int,int> &a, 
	              const pair<int,int> &b) 
	{ 
	    return (a.second < b.second); 
	} 

	long buyMaximumProducts(int n, long k, vector <int> a) {
	    // Complete this function
	    vector< pair <int, int> > vect;
	    for(int i = 0; i < n; i++) {
	        vect.push_back(make_pair(i, a[i]));
	    }
	    sort(vect.begin(), vect.end(), sortbysec); 
	    long moneyLeft = k;
	    long stocksTaken = 0;

	    for(int i = 0; i < n; i++) {
	        int val = vect[i].second;
	        int qtyBuy = vect[i].first+1;
	        int thisStockCost = val*qtyBuy;
	        if(moneyLeft > thisStockCost) {
	            
	            moneyLeft = moneyLeft - thisStockCost;
	            stocksTaken = stocksTaken + qtyBuy;
	        }
	         else {
	             stocksTaken = stocksTaken + moneyLeft/val;
	             thisStockCost = (moneyLeft/val) *val;
	             moneyLeft = moneyLeft - thisStockCost;
	         }
	    }
	    return stocksTaken;

	    
	}

	int main() {
	    int n;
	    cin >> n;
	    vector<int> arr(n);
	    for(int arr_i = 0; arr_i < n; arr_i++){
	    	cin >> arr[arr_i];
	    }
	    long k;
	    cin >> k;
	    long result = buyMaximumProducts(n, k, arr);
	    cout << result << endl;
	    return 0;
	}
}
