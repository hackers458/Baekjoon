#include <iostream>




int main()
{
    int length=0;
  int big;
  int big1;
  int same=0;

    char word[999999] = {'\0'};
    char Bword[26] = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
    char Sword[26] = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    int Bcount[26] = {0};
    int Scount[26] = {0};
    int Sumcount[26] = {0};
std::cin>>word;
while(5)
  {

if(word[length]=='\0')
{
  break;
}
    else{


      length++;
    }


    
  }



  
for(int a = 0 ; a<length;a++)
  {


for (int b = 0; b<26;b++)
  {

if(Bword[b]==word[a])
{
Bcount[b]++;


  
}

else if(Sword[b]==word[a])
{
    Scount[b]++;

    
  }

    
  }

    
}
for (int c = 0; c<26;c++)
  {
Sumcount[c] = Bcount[c] + Scount[c];

}

big =-1;
for (int c = 0; c<26;c++)
  {
if(big < Sumcount[c])
{
big = Sumcount[c];
big1 = c;
  

}


}

for(int c = 0;c<26;c++)
{

if(big == Sumcount[c])
{

same++;
  
}
  
  
}
  
  if(same > 1)
  {std::cout<<"?";
  }
  else{

    std::cout<<Bword[big1];
  }


return 0;
}