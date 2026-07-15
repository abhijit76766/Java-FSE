export interface Course {
  id: number;
  name: string;
  code: string;
  credits: number | null;
  gradeStatus: 'passed' | 'failed' | 'pending';
}

export interface Student {
  id: number;
  name: string;
  email: string;
}
