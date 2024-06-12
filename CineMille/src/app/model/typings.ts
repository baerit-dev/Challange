export type Projection = {
    id: number;
    auditorium: Auditorium;
    movie: Movie;
    startDate: Date;
    endDate: Date;    
}

export type Movie = {
    id: number;
    title: string;
    description: string;
    imageUrl: string;
}

export type Auditorium = {
    auditoriumNumber: number;
    seat: number;
    imax: boolean;    
}

export type Dir = 'ASC' | 'DESC'
export type Sort = 'start_date' | 'end_date'