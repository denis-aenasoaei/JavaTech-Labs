package com.lab2.lab2.BusinessLogic;

import com.sun.xml.internal.ws.util.StringUtils;

import java.util.ArrayList;

public class PermutationService {
    private FileService _fileService = new FileService();
    ArrayList<String> validWords = new ArrayList<>();

    public int getInitial_size() {
        return initial_size;
    }

    public void setInitial_size(int initial_size) {
        this.initial_size = initial_size;
    }

    public int initial_size = 0;

    public PermutationService(String validWordsFileName, int initial_size)
    {
        if(!(validWordsFileName == null || validWordsFileName.isEmpty()))
            this.validWords = this._fileService.GetWordListFromFile(validWordsFileName);

        this.initial_size = initial_size;
    }
    public void GetPermutations(String str, String ans, boolean only_valid, ArrayList<String> out_words)
    {
        if (str.length() == 0 || (ans.length() == this.initial_size  && this.initial_size != 0)) {
            if(!only_valid || this.validWords.contains(ans))
                out_words.add(ans);
            return;
        }

        for (int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i);

            // Rest of the string after excluding
            // the ith character
            String ros = str.substring(0, i) +
                    str.substring(i + 1);

            // Recursive call
            this.GetPermutations(ros, ans + ch, only_valid, out_words);
        }
    }
}
