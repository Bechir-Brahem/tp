import java.io.*;
import java.util.Scanner;
import java.lang.RuntimeException;

public class Menu {
	
	public static Scanner sc = new Scanner(System.in);
	
	public static void printMenu(){
		System.out.println("\t \t +--------------------------------------+");
		System.out.println("\t \t |                                      |");
		System.out.println("\t \t |                                      |");
		System.out.println("\t \t |   Welcome to my menu application!    |");
		System.out.println("\t \t |                                      |");
		System.out.println("\t \t |                                      |");
		System.out.println("\t \t +--------------------------------------+");
		System.out.println("\t \t Choose your command: \n \t \t 1- mkdir \n \t \t 2- rmdir \n \t \t 3- ls \n \t \t 4- rm \n \t \t 5- pwd \n \t \t 6- mv \n \t \t 7- touch \n \t \t 8- cat \n \t \t 9- cp \n \t \t 10- chmod");
	}
	
	
	//mkdir command
	public static void mkdir (){
		System.out.println("Directory name : ");
		String name = sc.next();
		File file = new File(name);
		boolean b = file.mkdir();
		if(b){
			System.out.println("Directory created successfully. ");
		}else{
			System.out.println("An error occured. ");
		}
	}

	//ls command
	public static void ls(){
		File file = new File(".");
		String[] files = file.list();
		for (int i = 0 ; i<files.length ; i++){
			System.out.println( files[i] + " ");
		}
	} 	
	
	//rm command
	public static void rm(){
		System.out.println("Name of the file to delete : ");
		String path = sc.next();
		File file = new File(path);
		if (!file.exists()){
				System.out.println("File does not exist.");
		}else{
			if (file.isFile()){
				if(file.delete()){
					System.out.println("File deleted successfully. ");
				}else{
					System.out.println("Could not delete file.");
				}
			} else {
				System.out.println("Error : not a file. ");
			}
		
		}
	}
	
	//rmdir command
	public static void rmdir(){
		System.out.println("Name of the directory to delete : ");
		String path = sc.next();
		File file = new File(path);
		if (!file.exists()){
				System.out.println("Directory does not exist.");
		}else{
			if (file.isDirectory()){
				if(file.delete()){
					System.out.println("Directory deleted successfully. ");
				}else{
					System.out.println("Could not delete Directory.");
				}
			} else {
				System.out.println("Error : not a directory. ");
			}
		
		}
	}
	
	
	//cat command
	public static void cat(){
		System.out.println("Donner le nom du fichier a afficher : ");
		String path = sc.next();
		try{
			BufferedReader in = new BufferedReader(new FileReader(path));
			String line;
			while( (line = in.readLine()) != null){
				System.out.println(line);
			}
			in.close();
		}catch (IOException e){
			e.printStackTrace();
		}
	}
	
	
	//cp command
	public static void cp() throws IOException{
		System.out.println("Donner le nom du fichier a copier : ");
		String pathSrc = sc.next();
		System.out.println("Donner le chemin de la copie : ");
		String pathDest = sc.next();
		

		try{
			File original = new File(pathSrc);
			File copied = new File(pathDest+"/CopyOf-"+original.getName());
			InputStream in = new BufferedInputStream(new FileInputStream(original));
			OutputStream out = new BufferedOutputStream(new FileOutputStream(copied));
			
				byte[] buffer = new byte[1024];
				int length;
				while ((length = in.read(buffer)) > 0){
					out.write(buffer, 0, length);
					out.flush();
				}
			System.out.println("File copied successfully. ");
		}catch (IOException e){
			e.printStackTrace();
		}
	}
	
	//pwd command
	public static void pwd(){
		File file = new File(".");
		try{
			System.out.println(file.getCanonicalPath());
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	//chmod command
	public static void chmod(){
		System.out.println("Name of the file : ");
		String path = sc.next();
		File file = new File(path);
		boolean arg;
		
		System.out.println("\n Permissions for this file : \n");
		if (file.canRead()){System.out.println("Readable \n");} else{System.out.println("Not readable \n");}
		if (file.canWrite()){System.out.println("Writable \n");} else{System.out.println("Not writable \n");}
		if (file.canExecute()){System.out.println("Executable \n");} else{System.out.println("Not executable \n");}
		
		//read permissions
		System.out.println("Read permission for owner : ");
		arg = sc.nextBoolean();
		file.setReadable(arg);
		System.out.println("Read permission for everyone : ");
		arg = sc.nextBoolean();
		file.setReadable(arg, false);
		
		//write permissions
		System.out.println("Write permission for owner : ");
		arg = sc.nextBoolean();
		file.setWritable(arg);
		System.out.println("Write permission for everyone : ");
		arg = sc.nextBoolean();
		file.setWritable(arg, false);
		
		//execute permissions
		System.out.println("Execute permission for owner : ");
		arg = sc.nextBoolean();
		file.setExecutable(arg);
		System.out.println("Execute permission for everyone : ");
		arg = sc.nextBoolean();
		file.setExecutable(arg, false);
		
		System.out.println("\n Updated permissions for this file : \n");
		if (file.canRead()){System.out.println("Readable \n");} else{System.out.println("Not readable \n");}
		if (file.canWrite()){System.out.println("Writable \n");} else{System.out.println("Not writable \n");}
		if (file.canExecute()){System.out.println("Executable \n");} else{System.out.println("Not executable \n");}
		
	}
	
	
	//rm -r command
	public static void recursiveRm(){
		
	}
	
	//mv command
	public static void mv() throws IOException {
		
		System.out.println("File(s) to move/rename : ");
		String source = sc.nextLine();
		source = sc.nextLine();
		System.out.println("Name of the destination directory : ");
		String destination = sc.next();
		File destinationDirectory = new File(destination);
		
		
		String srcArray[] = source.split(" ");
		
		if (!destinationDirectory.exists()){	
			
			if (srcArray.length == 1){
				File srcFile = new File(srcArray[0]);
	
				
				if (srcFile.renameTo(destinationDirectory)){
					System.out.println("File renamed successfully. ");
				}else{
					System.out.println("An error occured. ");
				}
			}else{
				System.out.println("No such file or directory destination. ");
			}
			
		} else{
				for (String s : srcArray){
						File original = new File(s);
						File to = new File(destination+"/"+s);
						//tester si le fichier existe
						if (!original.exists()){
							System.out.println("No such file or directory source. ");
							System.exit(1);
						}
						
						if (!original.renameTo(to)){
							System.out.println("Failed to move file. ");
							System.exit(1);
						}
				}
				System.out.println("Files moved successfully. ");
		}
	}	
	
	 //touch command
	public static void touch(){
		System.out.println("Name of the file : ");
		String name = sc.next();
		File file = new File(name);
		if(file.exists()){
			long newTime = System.currentTimeMillis();
			try{
				boolean b = file.setLastModified(newTime);
				if (b){
					System.out.println("File timestamp modified successfully. ");
				}else{
					System.out.println("An error occured. ");
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}else{
			try{
				boolean b = file.createNewFile();
				if (b){
						System.out.println("File created successfully. ");
				}else{
						System.out.println("An error occured. ");
				}
			}catch(Exception e){
				e.printStackTrace();
			}	
		}
	} 
	
	
	public static void main (String args[]){
		Menu.printMenu();
		int c = sc.nextInt();
		switch (c){
			case 1 :
				Menu.mkdir();
				break;
			case 2 :
				Menu.rmdir();
				break;
			case 3 :
				Menu.ls();
				break;
			case 4 :
				Menu.rm();
				break;
			case 5 :
				Menu.pwd();
				break;
			case 6 : 
				try{
					Menu.mv();
				}catch (IOException e){
					e.printStackTrace();
				}
				break;
			case 7 :
				Menu.touch();
				break;
			case 8 :
				Menu.cat();
				break;
			case 9 :
				try{
					Menu.cp();
					break;
				}catch(IOException e){
					e.printStackTrace();
				}
			case 10 :
				Menu.chmod();
				break;
			default: 
				System.out.println("Invalid choice. ");
		}
		
		
	}
}
