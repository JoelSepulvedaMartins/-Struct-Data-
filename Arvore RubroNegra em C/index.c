#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <string.h>

#define BLACK 0
#define RED 1

typedef struct arvoreRB {
	struct arvoreRB *left, *right;
	int count;
    char* palavra;
	int color; 
} ArvoreRB;

ArvoreRB* createNode(char* palavra);
ArvoreRB* rotateLeft(ArvoreRB* node);
ArvoreRB* rotateRight(ArvoreRB* node);
int isRed(ArvoreRB* node);
void swapColors(ArvoreRB* node);
ArvoreRB* insert(ArvoreRB* node, char *palavra);
void inOrder(ArvoreRB* ArvoreRB);
ArvoreRB* searchWord(ArvoreRB* node, char *palavra);
void handleFreq(int n, char* nomeArquivo);
void handleFreqWord(char *palavra, char* nomeArquivo);

int main(int argc, char *argv[]) {
    if (argc < 2) {
        printf("Insira um parametro valido!\nUso: %s [--freq N ARQUIVO | --freq-word PALAVRA ARQUIVO | --search TERMO ARQUIVO [ARQUIVO ...]]\n", argv[0]);
        return 1;
    }

    if (strcmp(argv[1], "--freq") == 0) {
        if (argc >= 4) {
            int n = atoi(argv[2]);
            char *nomeArquivo = argv[3];
            handleFreq(n, nomeArquivo);
            return 0;
        } else {
            printf("Invalid usage of --freq option.\n");
            return 1;
        }
    } 
    
    if (strcmp(argv[1], "--freq-word") == 0) {
        if (argc >= 4) {
            char *palavra = argv[2];
            char *nomeArquivo = argv[3];
            handleFreqWord(palavra, nomeArquivo);
        } else {
            printf("Invalid usage of --freq-word option.\n");
            return 1;
        }
    }

    // if (strcmp(argv[1], "--search") == 0) {
    //     if (argc >= 4) {
    //         char *termo = argv[2];
    //         printf("Option: --search TERMO=%s\n", termo);
    //         for (int i = 3; i < argc; i++) {
    //             printf("ARQUIVO=%s\n", argv[i]);
    //         }
    //     } else {
    //         printf("Invalid usage of --search option.\n");
    //     }
    // } else {
    //     printf("Invalid option: %s\n", argv[1]);
    // }

    // return 1;
    return 0;
}


void handleFreq(int n, char* nomeArquivo) {
    FILE *file = fopen(nomeArquivo, "r");
    if (file == NULL) {
        printf("Erro ao abrir o arquivo: %s\n", nomeArquivo);
        return;
    }

    ArvoreRB* root = NULL;

    char word[1024];

    while (fscanf(file, "%1023s", word) == 1) {
        int len = strlen(word);
        int j = 0;

        for (int i = 0; i < len; i++) {
            if (isalpha(word[i])) {
                word[j] = tolower(word[i]);
                j++;
            }
        }

        word[j] = '\0';

        if (strlen(word) >= 3) {
            root = insert(root, word);
        }
    }

    fclose(file);

    printf("In-order traversal of the tree:\n");
    inOrder(root);
}


void handleFreqWord(char *palavra, char* nomeArquivo) {
    FILE *file = fopen(nomeArquivo, "r");
    if (file == NULL) {
        printf("Erro ao abrir o arquivo: %s\n", nomeArquivo);
        return;
    }

    ArvoreRB* root = NULL;

    char word[1024];

    while (fscanf(file, "%1023[a-zA-Z]", word) == 1) {
        int len = strlen(word);
        int j = 0;

        for (int i = 0; i < len; i++) {
            if (isalpha(word[i])) {
                word[j] = tolower(word[i]);
                j++;
            }
        }

        word[j] = '\0';

        if (strlen(word) >= 3) {
            root = insert(root, word);
        }

        fscanf(file, "%*[^a-zA-Z]");
    }

    fclose(file);

    // inOrder(root);

    ArvoreRB* result = searchWord(root, palavra);

    if (result) {
        printf("Word: %s, Count: %d\n", result->palavra, result->count);
    } else {
        printf("Palavra \"%s\" nao encontrada no arquivo \"%s\"\n", palavra, nomeArquivo);
    }

    // liberar arvore
}

ArvoreRB* searchWord(ArvoreRB* node, char *palavra) {
    while (node != NULL) {
        int comparison = strcasecmp(palavra, node->palavra);

        if (comparison == 0) {
            return node;
        } else if (comparison < 0) {
            node = node->left;
        } else {
            node = node->right;
        }
    }

    return NULL; 
}


ArvoreRB* createNode(char* palavra) {
	ArvoreRB* node = (ArvoreRB*) malloc(sizeof(ArvoreRB));
	node->left = node->right = NULL;

    palavra = strdup(palavra);

    int j = 0;
    for (int i = 0; palavra[i]; i++) {
        if (isalpha(palavra[i])) {
            palavra[j] = tolower(palavra[i]);
            j++;
        }
    }

    palavra[j] = '\0';

    if (strlen(palavra) < 3) {
        free(node);
        return NULL;
    }

	node->palavra = palavra;
    node->count = 1;
	node->color = RED;

	return node;
}

ArvoreRB* rotateLeft(ArvoreRB* node) {
	ArvoreRB* child = node->right;
	ArvoreRB* childLeft = child->left;

	child->left = node;
	node->right = childLeft;

    child->color = node->color;
    node->color = RED;

	return child;
}

ArvoreRB* rotateRight(ArvoreRB* node) {
	ArvoreRB* child = node->left;
	ArvoreRB* childRight = child->right;

	child->right = node;
	node->left = childRight;

    child->color = node->color;
    node->color = RED;

	return child;
}

int isRed(ArvoreRB* node) {
	if (!node) {
	    return BLACK;
    }
	
    return (node->color == RED);
}

void swapColors(ArvoreRB* node) {
	node->color = RED;
    node->left->color = BLACK;
    node->right->color = BLACK;
}

ArvoreRB* insert(ArvoreRB* node, char *palavra) {
	if (node == NULL) {
		return createNode(palavra); 
    }

    int comparison = strcasecmp(palavra, node->palavra);
    
    if (comparison < 0) {
        node->left = insert(node->left, palavra);
    } else if (comparison > 0) {
        node->right = insert(node->right, palavra);
    } else {
        node->count++;
        return node;
    }

	if (isRed(node->right) && !isRed(node->left)) {
		node = rotateLeft(node);
	}

	if (isRed(node->left) && isRed(node->left->left)) { 
		node = rotateRight(node);
	}

	if (isRed(node->left) && isRed(node->right)) {
		swapColors(node);
	}

	return node;
}

void inOrder(ArvoreRB* ArvoreRB) {
	if (ArvoreRB) {
		inOrder(ArvoreRB->left);
		printf("%s %d\n", ArvoreRB->palavra, ArvoreRB->count);
		inOrder(ArvoreRB->right); 
	}
}

