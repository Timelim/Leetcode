#include <iostream>
#include <vector>
#include <queue>
using namespace std;
struct TreeNode
{
	int val;
	TreeNode *left;
	TreeNode *right;
	TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class Solution
{
	public:
		vector<vector<int>> levelOrderBottom(TreeNode *root)
		{
			queue<TreeNode *> tree;
			TreeNode *tmp=root;
			tree.push(tmp);
			vector<vector<int>> res;
			if(root==NULL)
				return res;
			while (!tree.empty())
			{
				vector<int> v;
				int len = tree.size();
				while(len>0)
				{
					tmp = tree.front();
					tree.pop();
					v.push_back(tmp->val);
					if(tmp->left!=NULL)
					{
						tree.push(tmp->left);
					}
					if(tmp->right!=NULL)
					{
						tree.push(tmp->right);
					}
					len-=1;
				}
				res.push_back(v);
			}
			reverse(res.begin(),res.end());
			return res;
		}
};

int main()
{
	return 0;
}
